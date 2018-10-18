package com.xiqianblog.dao;

import com.xiqianblog.datamodel.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 【描述内容】
 *
 * @Author: lvjc
 * @ProjectName: xiqianblog-parent
 * @PackageName: com.xiqianblog.dao
 * @Date: 创建时间 2018/10/18
 */
@Mapper
public interface UserDao
{
	/**
	 * 查询用户列表
	 *
	 * @return 用户列表
	 */
	List<User> queryUser();
}
