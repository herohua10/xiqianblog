package com.xiqianblog.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: Jian Hua
 * @date: 2018/11/12 19:25
 **/
@Component  //ContentService路由熔断
public class ContentServiceFallback implements FallbackProvider {

    private final Logger logger = LoggerFactory.getLogger(FallbackProvider.class);

    //指定要处理的 service
    @Override
    public String getRoute() {
        return "xqzx-content-service";
    }

    //fallbackResponse方法则是告诉 Zuul 断路出现时，它会提供一个ClientHttpResponse来处理请求
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

        if(cause != null && cause.getCause() != null) {
            String reason = cause.getCause().getMessage();
            logger.info("Exception {}", reason);
        }

        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("The service is unavailable.".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {

                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);

                return httpHeaders;
            }
        };
    }

}
