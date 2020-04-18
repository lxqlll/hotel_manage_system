package com.example.hotelmanagesys.modules.admin.info.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lxq
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "admin_info")
public class AdminInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId("id")
    private Integer id;

    private String name;

    private String password;

    private String sex;

    private String email;

    private String phone;

    private String address;

    private String question;

    private String answer;


}
