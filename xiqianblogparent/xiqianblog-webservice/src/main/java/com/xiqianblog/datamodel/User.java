package com.xiqianblog.datamodel;

import java.io.Serializable;

/**
 * 【描述内容】
 *
 * @Author: lvjc
 * @ProjectName: xiqianblog-parent
 * @PackageName: com.xiqianblog.datamodel
 * @Date: 创建时间 2018/10/18
 */
public class User implements Serializable
{
	/**
	 * 用户ID
	 */
	private long id;

	/**
	 * 用户名
	 */
	private String name;

	/**
	 * 密码
	 */
	private String password;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}
