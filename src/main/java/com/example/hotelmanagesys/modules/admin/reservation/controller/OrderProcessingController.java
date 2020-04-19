package com.example.hotelmanagesys.modules.admin.reservation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotelmanagesys.modules.client.room.entity.ClientRoomReservation;
import com.example.hotelmanagesys.modules.client.room.service.IClientRoomReservationService;
import com.example.hotelmanagesys.result.LayuiVo;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import com.example.hotelmanagesys.util.HiddenMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/order")
public class OrderProcessingController {

    Logger logger = LoggerFactory.getLogger(OrderProcessingController.class);

    @Autowired
    private IClientRoomReservationService iClientRoomReservationService;

    /**
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/processing")
    public LayuiVo queryOrderProcessing(Integer page,Integer limit){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("state",1);
        queryWrapper.apply("DATE_FORMAT(targetDate,'%Y-%M-%d') = DATE_FORMAT(NOW(),'%Y-%M-%d')");
        int count = iClientRoomReservationService.count();
        // 实例化创建分页对象
        // page 当前页
        // limit 每页显示条数
        Page page1 = new Page<ClientRoomReservation>(page,limit);
        //调用分页方法
        Page pageList =  iClientRoomReservationService.page(page1,queryWrapper);
        //获取Page对象中的集合System.out.println("<<<<<<<<<<<<<<<<<"+pageList.getRecords());
        List<ClientRoomReservation> clientRoomReservations =  pageList.getRecords();
        for(int i=0;i<clientRoomReservations.size();i++){
            logger.info("[for进入]");
            logger.info("[方法调用]"+HiddenMsg.infoHidden("1555554556"));
            logger.info("[集合id的值]"+clientRoomReservations.get(i).getIdCard());
            clientRoomReservations.get(i).setIdCard(HiddenMsg.infoHidden(clientRoomReservations.get(i).getIdCard()));
        }
        System.out.println(clientRoomReservations);
        return new LayuiVo(0,"",count,clientRoomReservations);
    }

    /**
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/historyReservation")
    public LayuiVo historyReservation(Integer page,Integer limit){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.apply("DATE_FORMAT(targetDate,'%Y-%M-%d') != DATE_FORMAT(NOW(),'%Y-%M-%d')");
        wrapper.eq("state",0);
        int result  = iClientRoomReservationService.count();
        // 实例化创建分页对象
        // page 当前页
        // limit 每页显示条数
        Page page1 = new Page<ClientRoomReservation>(page,limit);
        //调用分页方法
        Page pageList =  iClientRoomReservationService.page(page1,wrapper);
        //获取Page对象中的集合System.out.println("<<<<<<<<<<<<<<<<<"+pageList.getRecords());
        List<ClientRoomReservation> clientRoomReservations =  pageList.getRecords();
        for(int i=0;i<clientRoomReservations.size();i++){
            logger.info("[for进入]");
            logger.info("[方法调用]"+HiddenMsg.infoHidden("1555554556"));
            logger.info("[集合id的值]"+clientRoomReservations.get(i).getIdCard());
            clientRoomReservations.get(i).setIdCard(HiddenMsg.infoHidden(clientRoomReservations.get(i).getIdCard()));
        }
        System.out.println(clientRoomReservations);
        return new LayuiVo(0,"",result,clientRoomReservations);
    }

    @PostMapping("/validation")
    public Result validation(@RequestBody Map<String,Object> map){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id_card",map.get("identity"));
        queryWrapper.eq("phone",map.get("phone"));
        // 实例化创建分页对象
        // page 当前页
        // limit 每页显示条数
        //调用分页方法
        ClientRoomReservation clientRoomReservation =
                iClientRoomReservationService.getOne(queryWrapper);
        //获取Page对象中的集合System.out.println("<<<<<<<<<<<<<<<<<"+pageList.getRecords());
        if (clientRoomReservation!=null){
            return Response.ok();
        }else {
            return Response.error();
        }
    }
}
