package com.example.hotelmanagesys.modules.admin.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderInformationVo {
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("checkIn_time")
    private Date checkinTime;

    /**
     * 退房日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("CheckOut_time")
    private Date checkoutTime;

    /**
     * 支付方式
     */
    @TableField("MethodOf_payment")
    private String methodofPayment;

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
    /**
     * 预定客房编号
     */
    @TableId(value = "roomReservationId", type = IdType.AUTO)
    private Integer roomReservationId;
    /**
     * 预定编号
     */
    @TableField(value = "reserveId")
    private long reserveId;

    /**
     * 账号
     */
    @TableField("id_card")
    private String  idCard;

    /**
     * 预定人
     */
    @TableField("reserveName")
    private String reserveName;

    /**
     * 入住日期
     */
    @TableField("targetDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date targetDate;

    /**
     * 退房日期
     */
    @TableField("checkOutDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date checkOutDate;

    /**
     * 客人人数
     */
    private String guest;

    /**
     * 订单生成日期
     */

    @TableField("orderDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderDate;

    /**
     * 预定房间号
     */
    @TableField("roomNumber")
    private Integer roomNumber;
    /**
     *
     */
    private String mail;
    /**
     *
     */
    private String remark;
    /**
     *
     */
    @TableField(exist = false)
    private String guestRoomName;

    @TableField("roomPrice")
    private double roomPrice;

    private Integer state;

}
