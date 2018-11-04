package com.xiqianblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.xiqianblog.dao")
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    }
}
