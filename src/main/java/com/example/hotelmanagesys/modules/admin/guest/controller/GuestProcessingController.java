package com.example.hotelmanagesys.modules.admin.guest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotelmanagesys.modules.client.guest.entity.ClientGuestRoom;
import com.example.hotelmanagesys.modules.client.guest.service.IClientGuestRoomService;
import com.example.hotelmanagesys.result.LayuiVo;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import com.example.hotelmanagesys.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @RequestMapping(value="/uploadSource" , method = RequestMethod.POST,consumes = {"multipart/form-data"})
    public String uploadSource(@RequestPart("file") MultipartFile file, @RequestPart String guestRoomName,
                               String guestRoomStatus , BigDecimal price , String guestRoomArea
                               , String breakfast, String population, String bedType) {
        ClientGuestRoom clientGuestRoom = new ClientGuestRoom();
        clientGuestRoom.setGuestRoomStatus(guestRoomStatus);
        clientGuestRoom.setBedType(bedType);
        clientGuestRoom.setBreakfast(breakfast);
        clientGuestRoom.setGuestRoomName(guestRoomName);
        clientGuestRoom.setGuestRoomArea(guestRoomArea);
        clientGuestRoom.setPrice(price);
        clientGuestRoom.setPopulation(population);
        System.out.println(file);
        String pathString = null;
        if(file!=null) {
            //获取上传的文件名称
            String filename = file.getOriginalFilename();
            int unixSep = filename.lastIndexOf('/');
            int winSep = filename.lastIndexOf('\\');
            int pos = (winSep > unixSep ? winSep:unixSep);
            if (pos != -1)
                filename = filename.substring(pos + 1);
                pathString = "D:/idea_project/hotel_manage_system/src/main/resources/image/"
                        + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" +filename;//上传到本地
        }
        try {
            File files=new File(pathString);//在内存中创建File文件映射对象
            //打印查看上传路径
            System.out.println("================================>"+pathString);
            System.out.println("================================>"+clientGuestRoom.getGuestRoomName());
            if(!files.getParentFile().exists()){//判断映射文件的父文件是否真实存在
                files.getParentFile().mkdirs();//创建所有父文件夹
            }
            file.transferTo(files);//采用file.transferTo 来保存上传的文件
        } catch (Exception e) {
            e.printStackTrace();
        }
        clientGuestRoom.setGuestRoomPicture(pathString);
        iClientGuestRoomService.save(clientGuestRoom);
        return "{\"code\":0, \"msg\":\"success\", \"fileUrl\":\"" + pathString + "\"}";
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
//    @PostMapping("/queryGuestByAll")
//    public LayuiVo queryGuestByAll(String queryValue,Integer page, Integer limit){
//        QueryWrapper<ClientGuestRoom> query = new QueryWrapper<>();
//        query.like("guestRoomId",queryValue).or().like("guestRoomName",queryValue).or()
//                .like("price",queryValue).or().or().like("guestRoomStatus",queryValue).or()
//                .like("guestRoomArea",queryValue).or().like("breakfast",queryValue).or()
//                .like("population",queryValue).or().like("bedType",queryValue);
//        List<ClientGuestRoom> userList =iClientGuestRoomService.list(query);
//        return new LayuiVo(0,"",userList.size(),userList);
//   }
   @PostMapping("/updateGuestById")
   public Result updateGuestById(@RequestBody ClientGuestRoom clientGuestRoom){
        boolean flag=iClientGuestRoomService.updateById(clientGuestRoom);
        if (flag){
            return Response.ok();
        }else {
            return Response.error();
        }
   }

}
