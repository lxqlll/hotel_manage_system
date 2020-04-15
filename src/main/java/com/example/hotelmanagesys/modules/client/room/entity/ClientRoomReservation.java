package com.example.hotelmanagesys.modules.client.room.entity;

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
     * 账号
     */
    private String sex;

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
    private LocalDateTime targetDate;

    /**
     * 退房日期
     */
    @TableField("checkOutDate")
    private LocalDateTime checkOutDate;

    /**
     * 客人人数
     */
    private String guest;

    /**
     * 订单生成日期
     */
    @TableField("orderDate")
    private LocalDateTime orderDate;

    /**
     * 预定房间号
     */
    @TableField("roomNumber")
    private Integer roomNumber;


}
