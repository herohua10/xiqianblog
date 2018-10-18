package com.xiqianblog.controller;

import com.xiqianblog.message.common.ServerResponse;
import com.xiqianblog.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class TestController
{
	@Autowired
	private UserServiceImpl userServiceImpl;

    @ApiOperation(value = "测试POST接口", notes = "测试一下POST接口", tags = "Test",httpMethod = "POST")
    @RequestMapping(value = "/api/testPostMethod", method = RequestMethod.POST)
    public ServerResponse testPostMethod()
    {
        return ServerResponse.createBySuccess("测试POST接口成功", Arrays.asList("王鑫玉", "吕金成", "薛玢", "王卓", "华健", "王聪"));
    }

    @ApiOperation(value = "测试GET接口", notes = "测试一下GET接口", tags = "Test",httpMethod = "GET")
    @RequestMapping(value = "/api/testGetMethod", method = RequestMethod.GET)
    public ServerResponse testGetMethod()
    {
        return ServerResponse.createBySuccess("测试GET接口成功", "网警已介入，请注意言行");
    }

    @ApiOperation(value = "测试PUT接口", notes = "测试一下PUT接口", tags = "Test",httpMethod = "PUT")
    @RequestMapping(value = "/api/testPutMethod", method = RequestMethod.PUT)
    public ServerResponse testPutMethod()
    {
        return ServerResponse.createByErrorCodeMessage(404, "失败了，呜呜呜。。。");
    }

    @ApiOperation(value = "测试DELETE接口", notes = "测试一下DELETE接口", tags = "Test",httpMethod = "DELETE")
    @RequestMapping(value = "/api/testDeleteMethod", method = RequestMethod.DELETE)
    public ServerResponse testDeleteMethod()
    {
        return ServerResponse.createBySuccessMessage("小火鸡，成功啦！");
    }

	@ApiOperation(value = "测试data接口", notes = "测试一下data接口", tags = "Test", httpMethod = "POST")
	@RequestMapping(value = "/api/testData", method = RequestMethod.POST)
	public ServerResponse testData()
	{
		return ServerResponse.createBySuccess("查询成功", userServiceImpl.queryUser());
	}
}
