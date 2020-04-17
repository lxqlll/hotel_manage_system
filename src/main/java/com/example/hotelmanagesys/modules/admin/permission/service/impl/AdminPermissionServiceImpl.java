package com.example.hotelmanagesys.modules.admin.permission.service.impl;

import com.example.hotelmanagesys.modules.admin.permission.entity.AdminPermission;
import com.example.hotelmanagesys.modules.admin.permission.mapper.AdminPermissionMapper;
import com.example.hotelmanagesys.modules.admin.permission.service.IAdminPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxq
 * @since 2020-04-16
 */
@Service
public class AdminPermissionServiceImpl extends ServiceImpl<AdminPermissionMapper, AdminPermission> implements IAdminPermissionService {

    @Autowired
    private AdminPermissionMapper adminPermissionMapper;

    @Override
    public List<AdminPermission> getPermission(String userName) {
        return adminPermissionMapper.getPermission(userName);
    }


    /**
     * 获取子节点
     * @param id 父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    @Override
    public List getChild(int id, List<AdminPermission> allMenu){
        //子菜单
        List<AdminPermission> childList = new ArrayList<AdminPermission>();

        for (AdminPermission nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if(nav.getParentId()==id){
                childList.add(nav);
            }
        }
        //递归
        for (AdminPermission nav : childList) {
            nav.setChildren(getChild(nav.getPerId(), allMenu));
        }
        if(childList.size() == 0){
            return new ArrayList<AdminPermission>();
        }
        System.out.println(childList);
        return childList;
    }

}
