package com.example.hotelmanagesys.modules.client.infor.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelmanagesys.modules.client.infor.entity.InforMation;
import com.example.hotelmanagesys.modules.client.infor.service.IInforMationService;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import com.example.hotelmanagesys.result.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户个人信息表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/client/infor")
public class InforMationController {

    //声明IInforMationService对象
    @Autowired
    private IInforMationService iInforMationService;

    /**
     * 登录/查看个人信息方法
     * @param inforMation 客户个人信息表
     * @return
     */
    @PostMapping("/clientLogin")
    public Result clientLogin(@RequestBody InforMation inforMation){
        //实例化创建QueryWrapper对象
        QueryWrapper queryWrapper = new QueryWrapper();
        //添加条件 sql语句变成  ==>  select 字段名 from 表名 where  phone = 'inforMation.getPhone()的值'
        queryWrapper.eq("phone",inforMation.getPhone());
        //添加条件 sql语句变成  ==>  select 字段名 from 表名 where  phone = 'inforMation.getPhone()的值'  and password=''
        queryWrapper.eq("password",inforMation.getPassword());
        //调用查询用户名密码方法
        //调用条件查询的方法  返回类型 t 代表实体 所以实体接受
        InforMation info  = iInforMationService.getOne(queryWrapper);
        //判断是否有无数据
        if (null==info){
            return Response.error(ResultEnum.LOGIN_ERROR);
        }else{
            return Response.ok(info);
        }
    }


    /**
     * 注册方法
     * @param inforMation 客户个人信息表
     * @return
     */
    @PostMapping("/clientRegister")
    public Result clientRegister(@RequestBody InforMation inforMation){
        //调用新增方法
        boolean falg   = iInforMationService.save(inforMation);
        //判断是否有无数据
        if (!falg){
            return Response.error(ResultEnum.REPEAT_REGISTER);
        }else{
            return Response.ok("注册成功");
        }
    }

    /**
     * 修改个人信息方法
     * @param inforMation 客户个人信息表
     * @return
     */
    @PostMapping("/updateClientInfo")
    public Result updateClientInfo(@RequestBody InforMation inforMation){
        //调用修改方法
        boolean falg = iInforMationService.updateById(inforMation);
        //判断是否有无数据
        if (!falg){
            return Response.error(ResultEnum.UPDATE_ERROR);
        }else{
            return Response.ok("修改个人信息成功");
        }
    }
}
