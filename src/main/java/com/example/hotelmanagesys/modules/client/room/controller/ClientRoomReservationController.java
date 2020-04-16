package com.example.hotelmanagesys.modules.client.room.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelmanagesys.modules.client.room.entity.ClientRoomReservation;
import com.example.hotelmanagesys.modules.client.room.service.IClientRoomReservationService;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import com.example.hotelmanagesys.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 预定客房表 fk 客房信息编号 客户个人信息编号 前端控制器
 * </p>
 *
 * @author lxq
 * @since 2020-04-15
 */
@RestController
@RequestMapping("/room")
public class ClientRoomReservationController {
    @Autowired
    private IClientRoomReservationService iClientRoomReservationService;

    /**
     * 预定订单
     * @param clientRoomReservation
     * @return
     */
    @GetMapping("/queryRoomReservation")
    public Result queryRoomReservation(@RequestBody ClientRoomReservation clientRoomReservation){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("reserveName",clientRoomReservation.getReserveName());
        ClientRoomReservation client = iClientRoomReservationService.getOne(queryWrapper);
        if(client!=null){
            return Response.ok("订单查询成功");
        }else{
            return Response.error(ResultEnum.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/addRoomReservation")
    public Result addRoomReservation(@RequestBody ClientRoomReservation clientRoomReservation){
        boolean flag = iClientRoomReservationService.save(clientRoomReservation);
        if (flag==true){
            return Response.ok("订单预约成功");
        }else{
            return Response.error(ResultEnum.INTERNAL_SERVER_ERROR);
        }
    }



}
