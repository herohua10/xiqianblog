package com.xiqianblog;

import com.xiqianblog.datamodel.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class HttpClientTest
{
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testHttpClient()
    {
        User user = this.restTemplate.getForObject("http://localhost:8080/api/getUser", User.class);
        System.out.println(user);
    }
}
