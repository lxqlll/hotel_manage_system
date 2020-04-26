package com.example.hotelmanagesys.modules.admin.guest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotelmanagesys.modules.client.guest.entity.ClientGuestRoom;
import com.example.hotelmanagesys.modules.client.guest.service.IClientGuestRoomService;
import com.example.hotelmanagesys.modules.client.infor.entity.InforMation;
import com.example.hotelmanagesys.result.LayuiVo;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import com.example.hotelmanagesys.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.Query;
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
@RequestMapping("/admin/guest/")
public class GuestProcessingController {
    @Autowired
    private IClientGuestRoomService iClientGuestRoomService;
    @GetMapping("/processing")
    public LayuiVo queryOrderProcessing(Integer page, Integer limit){
            int count = iClientGuestRoomService.count();
            // 实例化创建分页对象
            // page 当前页
            // limit 每页显示条数
            Page page1 = new Page<ClientGuestRoom>(page,limit);
            //调用分页方法
            Page pageList =  iClientGuestRoomService.page(page1);
            //获取Page对象中的集合
            System.out.println("<<<<<<<<<<<<<<<<<"+pageList.getRecords());
            return new LayuiVo(0,"",count,pageList.getRecords());
    }

    /**
     * 新增客房
     * @param clientGuestRoom
     * @return
     */
    @PostMapping("/addGuest")
    public Result addGuest(@RequestBody ClientGuestRoom clientGuestRoom){
        clientGuestRoom.setGuestRoomPicture("123123");
        //调用修改方法
        boolean falg = iClientGuestRoomService.save(clientGuestRoom);
        //判断是否有无数据
        if (!falg){
            return Response.error(ResultEnum.ERROR);
        }else {
            return Response.ok();
        }
    }

    /**
     * 批量删除客房
     * @param idList
     * @return
     */
    @PostMapping("/removeGuestByIds")
    public Result removeGuestByIds(@RequestBody List<Integer> idList){
        boolean flag = iClientGuestRoomService.removeByIds(idList);
        if(!flag){
            return Response.error(ResultEnum.ERROR);
        }else {
            return  Response.ok();
        }
    }
    @PostMapping("/queryGuestByAll")
    public LayuiVo queryGuestByAll(String queryValue,Integer page, Integer limit){
        QueryWrapper<ClientGuestRoom> query = new QueryWrapper<>();
        query.like("guestRoomId",queryValue).or().like("guestRoomName",queryValue).or()
                .like("price",queryValue).or().or().like("guestRoomStatus",queryValue).or()
                .like("guestRoomArea",queryValue).or().like("breakfast",queryValue).or()
                .like("population",queryValue).or().like("bedType",queryValue);
        List<ClientGuestRoom> userList =iClientGuestRoomService.list(query);
        return new LayuiVo(0,"",userList.size(),userList);
   }
}
