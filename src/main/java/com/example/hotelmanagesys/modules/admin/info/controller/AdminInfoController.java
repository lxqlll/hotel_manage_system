package com.example.hotelmanagesys.modules.admin.info.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelmanagesys.modules.admin.info.entity.AdminInfo;
import com.example.hotelmanagesys.modules.admin.info.service.IAdminInfoService;
import com.example.hotelmanagesys.modules.client.infor.entity.InforMation;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import com.example.hotelmanagesys.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lxq
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/admin/info")
public class AdminInfoController {

    @Autowired
    private IAdminInfoService iAdminInfoService;
    /**
     *
     * @return
     */
    @PostMapping(value = "adminLogin")
    public Result adminLogin(@RequestBody AdminInfo adminInfo){
        //实例化创建QueryWrapper对象用
        QueryWrapper<AdminInfo> queryWrapper = new QueryWrapper<AdminInfo> ();
        //sql语句追加  例： slect 字段名 from 表名   追加:en==and or == or --------> where and name = #{}
        queryWrapper.eq("name", adminInfo.getName());
        queryWrapper.eq("password", adminInfo.getPassword());
        //调用查询方法根据用户名
        AdminInfo info  = iAdminInfoService.getOne(queryWrapper);
        if(info==null) {
            return Response.error();
        }else {
            return Response.ok(info);
        }
    }
}
