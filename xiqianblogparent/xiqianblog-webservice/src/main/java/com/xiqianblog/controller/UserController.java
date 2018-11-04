package com.xiqianblog.controller;

import com.xiqianblog.datamodel.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController
{
    @GetMapping("/getUser")
    public User getUser()
    {
        User user = new User();
        user.setId(1234);
        user.setName("isoftstone");
        user.setPassword("007");
        return user;
    }
}
