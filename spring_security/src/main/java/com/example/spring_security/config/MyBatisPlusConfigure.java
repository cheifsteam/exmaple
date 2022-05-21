package com.example.spring_security.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
//import com.example.spring_security.interceptor.DataPermissionInterceptor;
//import com.example.spring_security.interceptor.DesensitizationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Configuration
@MapperScan("com.example.spring_security.entity")
public class MyBatisPlusConfigure {
    /**
     * 注册数据权限
     */
//    @Bean
//    @Order(0)
//    public DataPermissionInterceptor dataPermissionInterceptor() {
//        return new DataPermissionInterceptor();
//    }
//
//    /**
//     * 数据脱敏
//     */
//    @Bean
//    @Order(-1)
//    public DesensitizationInterceptor desensitizationInterceptor() {
//        return new DesensitizationInterceptor();
//    }

    /**
     * 注册分页插件
     */
    @Bean
    @Order(-2)
   public  MybatisPlusInterceptor getMybatisPlusInterceptor(){
       MybatisPlusInterceptor interceptor=new MybatisPlusInterceptor();
       PaginationInnerInterceptor innerInterceptor=new PaginationInnerInterceptor();
       interceptor.addInnerInterceptor(innerInterceptor);
       return interceptor;
    }


}

