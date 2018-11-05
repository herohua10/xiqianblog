package com.xiqianblog.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xiqianblog.common.User.QueryUsersReq;
import com.xiqianblog.datamodel.User;

import java.io.IOException;
import java.util.List;

/**
 * 【描述内容】
 *
 * @Author: lvjc
 * @ProjectName: xiqianblog-parent
 * @PackageName: com.xiqianblog.service
 * @Date: 创建时间 2018/10/18
 */
public interface UserService
{
	List<User> queryUser(QueryUsersReq req);
}
