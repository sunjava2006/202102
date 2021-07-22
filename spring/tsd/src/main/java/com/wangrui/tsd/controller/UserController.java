package com.wangrui.tsd.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wangrui.tsd.bean.User;
import com.wangrui.tsd.service.UserService;

//@Controller
@RestController // @Controller + @ResponseBody
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login")  //将URL:"/login"映射到该方法
	//@ResponseBody      // 将该方法的返回值，做为返回给浏览器（响应）的内容。
	public Map login(@RequestBody User user) {
		Map map = new HashMap();
		
		// 讲求Model服务，完成用户的注册与校验
		System.out.println(user);
		userService.login(user);
		// 成功返回：
		map.put("user", user);
		map.put("status", "ok");
		
		return map;
	}
	
	@RequestMapping(value = "/logout")
	public void logout(String userName) {
		System.out.println("=============logout===========");
	}

}
