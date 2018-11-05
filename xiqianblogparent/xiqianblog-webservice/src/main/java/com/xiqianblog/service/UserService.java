package com.xiqianblog.service;

import com.xiqianblog.datamodel.User;
import com.xiqianblog.message.common.User.QueryUsersReq;
import org.springframework.stereotype.Service;

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
	List<User> queryUser();
}
