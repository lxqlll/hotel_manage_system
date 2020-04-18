package com.example.hotelmanagesys.modules.client.room.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelmanagesys.modules.client.room.entity.ClientRoomReservation;
import com.example.hotelmanagesys.modules.client.room.service.IClientRoomReservationService;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import com.example.hotelmanagesys.result.ResultEnum;
import com.example.hotelmanagesys.util.SystemTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
     * @param
     * @return
     */
    @PostMapping("/queryReservation/{guestRoomName2}")
    public Result queryRoomReservation(@PathVariable String guestRoomName2 ){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.like("reserveName",guestRoomName2);
        List<ClientRoomReservation> clientRoomReservations = iClientRoomReservationService.list(queryWrapper);
        if(clientRoomReservations!=null && clientRoomReservations.size()>0){
            return Response.ok(clientRoomReservations);
        }else{
            return Response.error(ResultEnum.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/addRoomReservation")
    public Result addRoomReservation(@RequestBody ClientRoomReservation clientRoomReservation){
        clientRoomReservation.setReserveId(SystemTime.nowTime());
        boolean flag = iClientRoomReservationService.save(clientRoomReservation);
        if (flag==true){
            return Response.ok("订单预约成功");
        }else{
            return Response.error(ResultEnum.INTERNAL_SERVER_ERROR);
        }
    }



}
