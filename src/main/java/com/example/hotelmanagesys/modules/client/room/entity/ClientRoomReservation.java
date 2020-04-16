package com.example.hotelmanagesys.modules.client.room.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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


    public String getGuestRoomName() {
        return guestRoomName;
    }

    public void setGuestRoomName(String guestRoomName) {
        this.guestRoomName = guestRoomName;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRoomReservationId() {
        return roomReservationId;
    }

    public void setRoomReservationId(Integer roomReservationId) {
        this.roomReservationId = roomReservationId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getReserveName() {
        return reserveName;
    }

    public void setReserveName(String reserveName) {
        this.reserveName = reserveName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
