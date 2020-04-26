package com.example.hotelmanagesys.modules.admin.admininfor.conllter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotelmanagesys.modules.admin.info.entity.AdminInfo;
import com.example.hotelmanagesys.modules.admin.info.service.IAdminInfoService;
import com.example.hotelmanagesys.modules.client.guest.entity.ClientGuestRoom;
import com.example.hotelmanagesys.result.LayuiVo;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import com.example.hotelmanagesys.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: hotel_manage_sys
 * @ClassName GuestProcessingController
 * @description:
 * @author: YXTJ
 * @create: 2020-04-18 17:06
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin/admininfro/")
public class AdminInfroProcessingController {
    @Autowired
    private IAdminInfoService iAdminInfoService;


    @GetMapping("/processing")
    public LayuiVo queryOrderProcessing(Integer page, Integer limit){
        int count = iAdminInfoService.count();
        // 实例化创建分页对象
        // page 当前页
        // limit 每页显示条数
        Page page1 = new Page<AdminInfo>(page,limit);
        //调用分页方法
        Page pageList =  iAdminInfoService.page(page1);
        //获取Page对象中的集合
        System.out.println("<<<<<<<<<<<<<<<<<"+pageList.getRecords());
        return new LayuiVo(0,"",count,pageList.getRecords());
    }

    /**
     * 新增管理员
     * @param adminInfo
     * @return
     */
    @PostMapping("/addAdminInfo")
    public Result addGuest(@RequestBody AdminInfo adminInfo){
        //调用修改方法
        boolean falg = iAdminInfoService.save(adminInfo);
        //判断是否有无数据
        if (!falg){
            return Response.error(ResultEnum.ERROR);
        }else {
            return Response.ok();
        }
    }

    /**
     * 批量删除管理员
     * @param idList
     * @return
     */
    @PostMapping("/removeAdminInfoByIds")
    public Result removeGuestByIds(@RequestBody List<Integer> idList){
        boolean flag = iAdminInfoService.removeByIds(idList);
        if(!flag){
            return Response.error(ResultEnum.ERROR);
        }else {
            return  Response.ok();
        }
    }
}
