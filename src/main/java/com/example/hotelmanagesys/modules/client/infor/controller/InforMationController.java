package com.example.hotelmanagesys.modules.client.infor.controller;


import com.example.hotelmanagesys.modules.client.infor.entity.InforMation;
import com.example.hotelmanagesys.modules.client.infor.service.IInforMationService;
import com.example.hotelmanagesys.result.Response;
import com.example.hotelmanagesys.result.Result;
import com.example.hotelmanagesys.result.ResultEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import java.util.Date;

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

    //打印本类
    Logger logger = LoggerFactory.getLogger(InforMationController.class);

    //声明IInforMationService对象
    @Autowired
    private IInforMationService iInforMationService;

    /**
     * 登录/查看个人信息方法
     * @param inforMation 客户个人信息表
     * @return
     */
    @PostMapping("/clientLogin")
    public Result clientLogin(@RequestBody InforMation inforMation) {
        //实例化创建Subject对象
        Subject subject = SecurityUtils.getSubject();
        //获取前端传来的用户名
        String phone = inforMation.getPhone();
        //获取前端传来的用密码
        String password = inforMation.getPassword();
        //传入用户名+密码
        UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
        try {
            //执行主体方法登录
            subject.login(token);
            logger.info("[{================>登录成功！！！！！！！！！！！！！}]" + new Date(System.currentTimeMillis()));
            return Response.ok(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal());
        } catch (UnknownAccountException e) {   //用户不存在
            logger.info("[{================>用户不存在！！！！！！！！！！！！！}]" + new Date(System.currentTimeMillis()));
            return Response.error(ResultEnum.NOT_FOUND);
        } catch (IncorrectCredentialsException e) {   //密码错误
            logger.info("[{================>密码错误！！！！！！！！！！！！！}]" + new Date(System.currentTimeMillis()));
            return Response.error(ResultEnum.PASSWORD_ERROR);
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
        boolean falg  = iInforMationService.save(inforMation);
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
        System.out.println(inforMation.getEmail());
        //判断是否有无数据
        if (!falg){
            return Response.error(ResultEnum.UPDATE_ERROR);
        }else{
            return Response.ok("新增用户成功");
        }
    }
}
