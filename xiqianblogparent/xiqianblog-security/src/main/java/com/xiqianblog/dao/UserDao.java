package com.xiqianblog.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiqianblog.common.ServerResponse;
import com.xiqianblog.common.User.QueryUsersReq;
import com.xiqianblog.datamodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDao
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<User> queryAllUsers(QueryUsersReq req)
    {

        List<ServiceInstance> webservices = discoveryClient.getInstances("webservice");

        ServiceInstance instance = webservices.get(0);

        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/api/getUsers";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> params = new HashMap<>();

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(params, httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        String responseBody = responseEntity.getBody();

        List<User> users = null;

        try
        {
            ServerResponse<List<User>> serverResponse = objectMapper.readValue(responseBody, new TypeReference<ServerResponse<List<User>>>(){});
            users = serverResponse.getData();
        } catch (IOException e)
        {
            System.out.println("IOException....");
        }

        return users;
    }
}
