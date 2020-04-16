package com.example.hotelmanagesys.modules.admin.permission.service;

import com.example.hotelmanagesys.modules.admin.permission.entity.AdminPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxq
 * @since 2020-04-16
 */
@Service
public interface IAdminPermissionService extends IService<AdminPermission> {

    public List<AdminPermission> getPermission(@Param("userName") String userName);

    /**
     * 获取子节点
     * @param id 父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    public List getChild(int id, List<AdminPermission> allMenu);
}
