package com.example.hotelmanagesys.modules.admin.info.entity;

/**
 * @program: hotel_manage_sys
 * @ClassName AdminPermission
 * @description:
 * @author: YXTJ
 * @create: 2020-04-26 17:04
 * @Version 1.0
 **/

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminPermission implements Serializable {
 private int count;
 private int perId;
 private String pemame;
 private String percode;
 private int parentId;
 private String roleName;
}
