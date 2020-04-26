package com.example.hotelmanagesys.modules.admin.order.controller;


import com.example.hotelmanagesys.modules.admin.info.entity.AdminInfo;
import com.example.hotelmanagesys.modules.admin.info.entity.AdminPermission;
import com.example.hotelmanagesys.modules.admin.order.entity.OrderInformationVo;
import com.example.hotelmanagesys.modules.admin.order.entity.ServiceOrderInformation;
import com.example.hotelmanagesys.modules.admin.order.service.IServiceOrderInformationService;
import com.example.hotelmanagesys.modules.client.room.entity.ClientRoomReservation;
import com.example.hotelmanagesys.modules.client.room.service.IClientRoomReservationService;
import com.example.hotelmanagesys.result.LayuiVo;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 订单信息表 fk 预定客房编号 前端控制器
 * </p>
 *
 * @author lxq
 * @since 2020-04-19
 */
@RestController
@RequestMapping(value = "/order/information")
public class ServiceOrderInformationController {

    @Autowired
    private IClientRoomReservationService iClientRoomReservationService;


    @Autowired
    private IServiceOrderInformationService iServiceOrderInformationService;

    @PostMapping(value = "/addOrder")
    public Result addOrder(@RequestBody ClientRoomReservation reservation){
        ServiceOrderInformation orderInformation=null;
        if(reservation!=null) {
            reservation = iClientRoomReservationService.getById(reservation.getRoomReservationId());
            orderInformation = new ServiceOrderInformation();
            orderInformation.setReservationId(reservation.getRoomReservationId());
            orderInformation.setHotelLocation("三亚市蜂蜜大道");
            orderInformation.setHotelName("来秀客");
            orderInformation.setIsSubscribe(1);
            orderInformation.setMethodofPayment("预定支付");
        }
        try {
            iServiceOrderInformationService.save(orderInformation);
            return Response.ok();
        } catch (Exception e) {
            return Response.error();
        }
    }

    @GetMapping("/findOrder")
    public LayuiVo findOrder(int page,int limit){
        int index = (page-1)*limit;
        int cout = iServiceOrderInformationService.findOrderInformationCount();
        List<OrderInformationVo> list
                = iServiceOrderInformationService.findOrderInformation(index,limit);
        return new LayuiVo(0,"",cout,list);
    }
    @RequestMapping("/queryMean")
    public String queryMean(@RequestBody AdminInfo adminInfo){
        List<AdminPermission> adminInfoList= iServiceOrderInformationService.queryMevan(adminInfo);
        int count = adminInfoList.get(0).getCount();
        System.out.println(count);
        for (int i=0;i<adminInfoList.size();i++){
            System.out.println(adminInfoList.get(i));
        }
        if (count!=0){
            return "index";
        }else{
            return "login";
        }

    }
}
