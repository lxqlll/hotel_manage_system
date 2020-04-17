package com.example.hotelmanagesys.modules.client.inforpaging.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotelmanagesys.modules.client.infor.entity.InforMation;
import com.example.hotelmanagesys.modules.client.infor.service.IInforMationService;
import com.example.hotelmanagesys.result.LayuiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return new LayuiVo(0,"",count,pageList.getRecords());
    }
}
