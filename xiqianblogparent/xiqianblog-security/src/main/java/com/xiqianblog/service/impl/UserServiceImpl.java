package com.xiqianblog.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xiqianblog.common.User.QueryUsersReq;
import com.xiqianblog.dao.UserDao;
import com.xiqianblog.datamodel.User;
import com.xiqianblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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

	@Override
	public List<User> queryUser(QueryUsersReq req)
    {
		return userDao.queryAllUsers(req);
	}
}