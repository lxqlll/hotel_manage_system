package com.example.hotelmanagesys.modules.client.room.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelmanagesys.modules.client.guest.entity.ClientGuestRoom;
import com.example.hotelmanagesys.modules.client.guest.service.IClientGuestRoomService;
import com.example.hotelmanagesys.modules.client.infor.controller.InforMationController;
import com.example.hotelmanagesys.modules.client.room.entity.ClientRoomReservation;
import com.example.hotelmanagesys.modules.client.room.service.IClientRoomReservationService;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import com.example.hotelmanagesys.result.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //打印本类
    Logger logger = LoggerFactory.getLogger(ClientRoomReservationController.class);

    @Autowired
    private IClientRoomReservationService iClientRoomReservationService;

    @Autowired
    private IClientGuestRoomService iClientGuestRoomService;
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
        System.out.println(clientRoomReservation.getGuestRoomName());

        logger.info("[方法进入][房间号为]"+clientRoomReservation.getGuestRoomName());
        boolean flag = iClientRoomReservationService.save(clientRoomReservation);
        if (flag==true){
            logger.info("修改成功");
            String  guestRoomName = clientRoomReservation.getGuestRoomName();
            QueryWrapper queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("guestRoomName",guestRoomName);
            ClientGuestRoom clientGuestRoom =  iClientGuestRoomService.getOne(queryWrapper);
            logger.info(clientGuestRoom.toString());
            if(clientGuestRoom!=null){
                clientGuestRoom.setGuestRoomStatus("已预定");
                boolean falg2 =iClientGuestRoomService.updateById(clientGuestRoom);
                System.out.println("修改成功！");
            }
            return Response.ok("成功");
        }else{
            return Response.error(ResultEnum.INTERNAL_SERVER_ERROR);
        }
    }



}
