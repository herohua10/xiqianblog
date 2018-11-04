package com.xiqianblog.controller;

import com.xiqianblog.datamodel.User;
import com.xiqianblog.message.common.User.queryUsersReq;
import com.xiqianblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/getUsers")
    public List<User> getUser(@RequestBody queryUsersReq req)
    {
        return userService.queryUser();
    }
}
