package com.xiqianblog.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiqianblog.dao.UserDao;
import com.xiqianblog.datamodel.User;
import com.xiqianblog.message.common.User.QueryUsersReq;
import com.xiqianblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 【描述内容】
 *
 * @Author: lvjc
 * @ProjectName: xiqianblog-parent
 * @PackageName: com.xiqianblog.service.impl
 * @Date: 创建时间 2018/10/18
 */
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;

	// 断路器超时时间7s
	@HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "7000")},
                    fallbackMethod = "buildFallbackUsers")
	@Override
	public List<User> queryUser()
	{
        randomlyRunLong();

		return userDao.selectAll();
	}

	// 后备方法
	private List<User> buildFallbackUsers()
    {
        List<User> users = new ArrayList<>();

        User user = new User();
        user.setId(32619834);
        user.setName("jy");
        user.setPassword("21433558");

        users.add(user);
        return users;
    }

	private void randomlyRunLong()
    {
        Random random = new Random();

        int randonNum = random.nextInt((3 - 1) + 1) + 1;

        if (randonNum == 3)
        {
            sleep();
        }
    }

	private void sleep()
    {
        try
        {
            Thread.sleep(11000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
