package com.example.hotelmanagesys.modules.client.inforpaging.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotelmanagesys.modules.admin.info.entity.AdminInfo;
import com.example.hotelmanagesys.modules.client.infor.entity.InforMation;
import com.example.hotelmanagesys.modules.client.infor.service.IInforMationService;
import com.example.hotelmanagesys.result.LayuiVo;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import com.example.hotelmanagesys.result.ResultEnum;
import com.example.hotelmanagesys.util.HiddenMsg;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: hotel_manage_sys
 * @ClassName InforProcessingController
 * @description:
 * @author: YXTJ
 * @create: 2020-04-17 15:38
 * @Version 1.0
 **/
@RestController
@RequestMapping("/client/informing/")
public class InforProcessingController {
    @Autowired
    private IInforMationService iInforMationService;

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/inforprocessing")
    public LayuiVo queryOrderProcessing(Integer page, Integer limit){
        int count = iInforMationService.count();
        // 实例化创建分页对象
        // page 当前页
        // limit 每页显示条数
        Page page1 = new Page<InforMation>(page,limit);
        //调用分页方法
        Page pageList =  iInforMationService.page(page1);
        //获取Page对象中的集合
        System.out.println("<<<<<<<<<<<<<<<<<"+pageList.getRecords());
        List<InforMation> inforMationList = pageList.getRecords();
        for (int i=0;i<inforMationList.size();i++){
            System.out.println(inforMationList.get(i));
            inforMationList.get(i).setPassword(HiddenMsg.infoHidden(inforMationList.get(i).getPassword()));
        }
        System.out.println(inforMationList);
        return new LayuiVo(0,"",count,inforMationList);

    }

    /**
     * 新增客户账号
     * @param inforMation
     * @return
     */
    @PostMapping("/addInforMation")
    public Result addUserInfo(@RequestBody InforMation inforMation){
        //调用修改方法
        boolean falg = iInforMationService.save(inforMation);
        //判断是否有无数据
        if (!falg){
            return Response.error(ResultEnum.ERROR);
        }else {
            return Response.ok();
        }
    }

    /**
     * 批量删除
     * @param idList id集合
     * @return
     */
    @PostMapping("/removeInforMationByIds")
    public Result removeInforMationByIds(@RequestBody List<Integer> idList){
        boolean flag = iInforMationService.removeByIds(idList);
        if(!flag){
            return Response.error(ResultEnum.ERROR);
        }else {
            return  Response.ok();
        }
    }
    @PostMapping("/updateInfoById")
    public Result updateInfoById(@RequestBody  InforMation inforMation){
        boolean flag=iInforMationService.updateById(inforMation);
        if (flag){
            return Response.ok();
        }else {
            return Response.error();
        }
    }
//    @PostMapping("/queryInfroMationByAll")
//    public  Result queryInfroMationByAll(@RequestBody String allInfroMation) {
//
//   }
}
