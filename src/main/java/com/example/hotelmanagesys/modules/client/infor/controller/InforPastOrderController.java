package com.example.hotelmanagesys.modules.client.infor.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelmanagesys.modules.client.infor.entity.InforPastOrder;
import com.example.hotelmanagesys.modules.client.infor.service.InforPastOrderService;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/infor")
public class InforPastOrderController {
    
    @Autowired
    private InforPastOrderService inforPastOrderService;

    /**
     * 根据用户编号查询往期订单
     * @param inforPastOrder
     * @return
     */
    @PostMapping("/queryInforPastOrder")
    private Result queryInforPastOrder(@RequestBody InforPastOrder inforPastOrder){
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("inforId",inforPastOrder.getInforId());
        List<InforPastOrder> inforPastOrderList = inforPastOrderService.list(wrapper);
        return Response.ok("成功了");
    }

    /**
     *根据用户编号查询预订订单
     * @param inforPastOrder
     * @return
     */
    @PostMapping("/queryInforReserve")
    private Result queryInforReserve(@RequestBody InforPastOrder inforPastOrder){
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("inforId",inforPastOrder.getInforId());
        List<InforPastOrder> inforPastOrderList = inforPastOrderService.list(wrapper);
        return Response.ok("成功了");
    }
}
