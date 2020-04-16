package com.example.hotelmanagesys.config.shiro;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 *
 */
@Configuration
public class ShiroConfig {

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //创建集合
        Map<String, String> filterMap = new LinkedHashMap<String, String>();
//      filterMap.put("/user/login","authc");
        //需要权限
//        filterMap.put("/book/getBook","perms[user:export]");
        //需要登录
//        filterMap.put("/modules/front/personal.html","authc");
////
//        filterMap.put("/modules/front/book.html","authc");
////        //设置拦截路径
//        bean.setFilterChainDefinitionMap(filterMap);
//        bean.setFilterChainDefinitions("/ajaxLogin");
////        //设置登录路径
//        bean.setLoginUrl("/modules/login/login.html");
//        //设置未授权路径
//        bean.setUnauthorizedUrl("/book/getBook");

        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        return bean;
    }

    /**
     *
     * @param myRealm
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return  securityManager;
    }

    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }

    /**
     * 注入配置凭证匹配器
     * @return   配置凭证匹配器 {@link org.apache.shiro.authc.credential.HashedCredentialsMatcher}
     */
   //@Bean(name = "credentialsMatcher")
    public HashedCredentialsMatcher gethashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //加盐方式
        credentialsMatcher.setHashAlgorithmName("md5");
        //散装次数
        credentialsMatcher.setHashIterations(2);
        return credentialsMatcher;
    }

}
