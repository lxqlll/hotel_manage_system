package com.example.hotelmanagesys.modules.admin.permission.controller;


import com.example.hotelmanagesys.modules.admin.permission.entity.AdminPermission;
import com.example.hotelmanagesys.modules.admin.permission.service.IAdminPermissionService;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lxq
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/admin/permission")
public class AdminPermissionController {
    @Autowired
    private IAdminPermissionService iAdminPermissionService;
    /**
     * 权限
     * @return
     */
    @PostMapping(value = "/adminPermission/{UserName}")
    public Result adminPermission(@PathVariable String UserName){

        List<AdminPermission> adminPermissions =
                iAdminPermissionService.getChild(0,iAdminPermissionService.getPermission(UserName));

        if(adminPermissions==null && adminPermissions.size()<0) {
            return Response.error();
        }else {
            return Response.ok(adminPermissions);
        }
    }
}
