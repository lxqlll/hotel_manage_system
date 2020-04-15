package com.example.hotelmanagesys.modules.client.guest.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.hotelmanagesys.modules.client.guest.entity.ClientGuestRoom;
import com.example.hotelmanagesys.modules.client.guest.service.IClientGuestRoomService;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import com.example.hotelmanagesys.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * <p>
 * 客房信息表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-04-14
 */
@RestController
@RequestMapping("/guest/room")
public class ClientGuestRoomController {

    @Autowired
    private IClientGuestRoomService iClientGuestRoomService;

    /**
     * 查询所有客房信息
     * @return
     */
    @RequestMapping("/queryRoom")
    public Result queryRoom(){
        // List<T> 返回类型集合 集合接收
        List<ClientGuestRoom> clientGuestRoomList = iClientGuestRoomService.list();

        List<ClientGuestRoom> collects = clientGuestRoomList.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ClientGuestRoom::getPrice))), ArrayList::new));

        if(clientGuestRoomList.size()>0){
            return Response.ok(collects);
        }else {
            return Response.error(ResultEnum.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 新增客房信息
     * @param clientGuestRoom
     * @return
     */
    @RequestMapping("/addRoom")
    public Result addRoom(@RequestBody ClientGuestRoom clientGuestRoom){
        boolean falg = iClientGuestRoomService.save(clientGuestRoom);
        if(falg==true){
            return Response.ok("客房新增成功");
        }else{
            return Response.error(ResultEnum.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 删除客房信息
     * @param clientGuestRoom
     * @return
     */
    @RequestMapping("/deleteRoom")
    public Result deleteRoom(@RequestBody ClientGuestRoom clientGuestRoom){
        boolean falg = iClientGuestRoomService.removeById(clientGuestRoom.getGuestRoomId());
        if(falg==true){
            return Response.ok("客房删除成功");
        }else{
            return Response.error(ResultEnum.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 修改客房信息
     * @param clientGuestRoom
     * @return
     */
    @RequestMapping("/updateRoom")
    public Result updateRoom(@RequestBody ClientGuestRoom clientGuestRoom){
        boolean flag = iClientGuestRoomService.updateById(clientGuestRoom);
        if(flag==true){
            return Response.ok("客房修改成功");
        }else{
            return Response.error(ResultEnum.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 根据客房名字查询
     * @param clientGuestRoom
     * @return
     */
    @RequestMapping("/queryGuestRoomName")
    public Result queryGuestRoomName(@RequestBody ClientGuestRoom clientGuestRoom){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("guestRoomName",clientGuestRoom.getGuestRoomName());
        ClientGuestRoom client = iClientGuestRoomService.getOne(queryWrapper);
        if(client!=null){
            return Response.ok("条件查询成功");
        }else{
            return Response.error(ResultEnum.INTERNAL_SERVER_ERROR);
        }

    }


}
