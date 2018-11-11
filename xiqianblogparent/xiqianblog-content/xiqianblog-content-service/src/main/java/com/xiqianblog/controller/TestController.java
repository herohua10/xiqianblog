package com.xiqianblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Jian Hua
 * @date: 2018/11/11 21:50
 **/
@RestController
public class TestController {

    @RequestMapping("/testFirstMethod")
    public void testFirstMethod() {
        System.out.println("successfully");
    }
}
