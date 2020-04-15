package com.example.hotelmanagesys.config.shiro;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelmanagesys.modules.client.infor.entity.InforMation;
import com.example.hotelmanagesys.modules.client.infor.service.IInforMationService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @remark shiro 配置类
 * @author admin
 * @createTime 2020年3月31日13点56分
 * @version 1.0
 */
public class MyRealm extends AuthorizingRealm {


    @Autowired
    private IInforMationService iInforMationService;

    /**
     * 角色权限方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        //获取用户所有信息
//        Customer customer =(Customer)principalCollection.getPrimaryPrincipal();
//        //实例化创建SimpleAuthorizationInfo对象
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        //获取用户角色
//        List<String> roleList = iRoleService.queryRoleByName(customer.getName());
//        //获取用户权限
//        List<String> permissionList = iPermissionService.queryPermissionByName(customer.getName());
//        //判断有无数据
//        if(roleList.size()>0){
//                info.addRoles(roleList);    //添加角色
//        }
//        //判断有无数据
//        if(permissionList.size()>0){
//            info.addStringPermissions(permissionList);  //添加权限
//        }
//        return info;
        return  null;
    }

    /**
     * 登录方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取电话号码
        String phone = authenticationToken.getPrincipal().toString();
        //实例化创建QueryWrapper对象用
        QueryWrapper<InforMation> queryWrapper = new QueryWrapper<InforMation> ();
        //sql语句追加  例： slect 字段名 from 表名   追加:en==and or == or --------> where and name = #{}
        queryWrapper.eq("phone", phone);
        //调用查询方法根据用户名
        InforMation inforMation  = iInforMationService.getOne(queryWrapper);
        //判断有无数据
        if(null==inforMation){
            return null;
        }else {
            //实例化创建ByteSource对象   加盐方式 用户名+地址
           //ByteSource byteSource = ByteSource.Util.bytes(customer.getName()+customer.getAddress());

            //实例化创建SimpleAuthenticationInfo对象
            SimpleAuthenticationInfo info =
                        new SimpleAuthenticationInfo(inforMation,inforMation.getPassword(),this.getName());
            return info;
        }
    }
}
