package com.example.hotelmanagesys.modules.client.guest.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 客房信息表
 * </p>
 *
 * @author jobob
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("client_guest_room")
public class ClientGuestRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客房信息编号
     */
    @TableId(value = "guestRoomId",type = IdType.AUTO)
    private Integer guestRoomId;

    /**
     * 客房名字
     */
    @TableField("guestRoomName")
    private String guestRoomName;

    /**
     * 客房价格
     */
    private BigDecimal price;

    /**
     * 客房状况
     */
    @TableField("guestRoomStatus")
    private String guestRoomStatus;

    /**
     * 客房面积
     */
    @TableField("guestRoomArea")
    private String guestRoomArea;

    /**
     * 是否含有早餐
     */
    private String breakfast;

    /**
     * 可住人数
     */
    private String population;

    /**
     * 床型
     */
    @TableField("bedType")
    private String bedType;

    /**
     * 备注1
     */
    private String note;

    /**
     * 备注2
     */
    @TableField("noteTwo")
    private String noteTwo;

    /**
     * 备注3
     */
    @TableField("noteThree")
    private String noteThree;

    /**
     * 客房照片
     */
    @TableField("guestRoomPicture")
    private String guestRoomPicture;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getGuestRoomId() {
        return guestRoomId;
    }

    public void setGuestRoomId(Integer guestRoomId) {
        this.guestRoomId = guestRoomId;
    }

    public String getGuestRoomName() {
        return guestRoomName;
    }

    public void setGuestRoomName(String guestRoomName) {
        this.guestRoomName = guestRoomName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGuestRoomStatus() {
        return guestRoomStatus;
    }

    public void setGuestRoomStatus(String guestRoomStatus) {
        this.guestRoomStatus = guestRoomStatus;
    }

    public String getGuestRoomArea() {
        return guestRoomArea;
    }

    public void setGuestRoomArea(String guestRoomArea) {
        this.guestRoomArea = guestRoomArea;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNoteTwo() {
        return noteTwo;
    }

    public void setNoteTwo(String noteTwo) {
        this.noteTwo = noteTwo;
    }

    public String getNoteThree() {
        return noteThree;
    }

    public void setNoteThree(String noteThree) {
        this.noteThree = noteThree;
    }

    public String getGuestRoomPicture() {
        return guestRoomPicture;
    }

    public void setGuestRoomPicture(String guestRoomPicture) {
        this.guestRoomPicture = guestRoomPicture;
    }
}
