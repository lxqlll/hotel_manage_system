package com.example.hotelmanagesys.modules.admin.permission.mapper;

import com.example.hotelmanagesys.modules.admin.permission.entity.AdminPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxq
 * @since 2020-04-16
 */
@Mapper
@Repository
public interface AdminPermissionMapper extends BaseMapper<AdminPermission> {
    public List<AdminPermission> getPermission(@Param("userName") String userName);
}
