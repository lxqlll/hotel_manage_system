package com.example.hotelmanagesys.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @remark mybatis plus分页配置类
 * @author admin
 * @createTime 2020年3月31日13点56分
 * @version 1.0
 */
@Configuration   //声明为配置类
@EnableTransactionManagement
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
