package com.example.hotelmanagesys.modules.admin.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotelmanagesys.modules.client.room.entity.ClientRoomReservation;
import com.example.hotelmanagesys.modules.client.room.service.IClientRoomReservationService;
import com.example.hotelmanagesys.result.LayuiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/order")
public class OrderProcessingController {

    @Autowired
    private IClientRoomReservationService iClientRoomReservationService;

    @GetMapping("/processing")
    public LayuiVo queryOrderProcessing(Integer page,Integer limit){
        int count = iClientRoomReservationService.count();
        // 实例化创建分页对象
        // page 当前页
        // limit 每页显示条数
        Page page1 = new Page<ClientRoomReservation>(page,limit);
        //调用分页方法
        Page pageList =  iClientRoomReservationService.page(page1);
        //获取Page对象中的集合
        System.out.println("<<<<<<<<<<<<<<<<<"+pageList.getRecords());
        return new LayuiVo(0,"",count,pageList.getRecords());
    }
}
