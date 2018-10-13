package com.xiqianblog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config
{
    @Bean
    public Docket getDocket()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiqianblog.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
                .title("洗钱中心Restful API")
                .description("洗钱中心Blog系统Restful API")
                .termsOfServiceUrl("http://127.0.0.1:8080/")
                .contact(new Contact("huajian", "", "hero514346219@163.com"))
                .version("1.0")
                .build();
    }
}
