package com.xiqianblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//@EnableDiscoveryClient
@SpringBootApplication
public class SecurityApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    }
}
