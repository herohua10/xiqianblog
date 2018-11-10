package com.xiqianblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: Jian Hua
 * @date: 2018/11/10 15:45
 **/
@SpringBootApplication
@EnableEurekaServer     //开启Eureka注册服务
public class RegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistryApplication.class, args);
    }
}
