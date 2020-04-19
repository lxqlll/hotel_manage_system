package com.example.hotelmanagesys.modules.admin.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单信息表 fk 预定客房编号
 * </p>
 *
 * @author lxq
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("service_order_information")
public class ServiceOrderInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单信息编号
     */
    @TableId(value = "orderInformationId", type = IdType.AUTO)
    private Integer orderInformationId;

    /**
     * 是否确认订单
     */
    @TableField("orderNotarize")
    private String orderNotarize;

    /**
     * 入住时间
     */
    @TableField("checkIn_time")
    private LocalDateTime checkinTime;

    /**
     * 退房日期
     */
    @TableField("CheckOut_time")
    private LocalDateTime checkoutTime;

    /**
     * 支付方式
     */
    @TableField("MethodOf_payment")
    private Double methodofPayment;

    /**
     * 是否预约 1、网上预约 2、线下预约
     */
    private Integer isSubscribe;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 酒店位置
     */
    private String hotelLocation;

    /**
     * 入住人
     */
    private String checkPerson;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 预约表id
     */
    private Integer reservationId;

    /**
     * 备用
     */
    private String standby1;

    /**
     * 备用
     */
    private String standby3;

    /**
     * 备用
     */
    private String standby2;


}
