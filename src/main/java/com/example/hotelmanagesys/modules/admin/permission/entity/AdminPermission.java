package com.example.hotelmanagesys.modules.admin.permission.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

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
public class AdminPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("perId")
    private Integer perId;

    private String pemame;

    private String percode;

    @TableField("parentId")
    private Integer parentId;

    @TableField(exist = false)
    private List children;
}
