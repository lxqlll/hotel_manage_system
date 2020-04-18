package com.example.hotelmanagesys.modules.client.room.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 预定客房表 fk 客房信息编号 客户个人信息编号
 * </p>
 *
 * @author lxq
 * @since 2020-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("client_room_reservation")
public class ClientRoomReservation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 预定客房编号
     */
    @TableId(value = "roomReservationId", type = IdType.AUTO)
    private Integer roomReservationId;
    /**
     * 预定编号
     */
    private long reserveId;

    /**
     * 账号
     */
    private String  IDCard;

    /**
     * 预定人
     */
    @TableField("reserveName")
    private String reserveName;

    /**
     * 电话
     */
    private String phone;

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

    private BigDecimal roomPrice;

}
