package com.xiqianblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: Jian Hua
 * @date: 2018/11/10 15:54
 **/
@SpringBootApplication
@EnableEurekaClient     //向Eureka注册该服务
@EnableZuulProxy        //使之成为zuul服务器
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
