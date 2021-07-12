package com.wangrui.checkin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@RequestMapping("/login")
	@ResponseBody
	public Map login(String loginName, String pwd) {
		Map map = new HashMap();
		if("admin".equals(loginName) && "123456".equals(pwd)) {
			map.put("msg", "loginOK");
		}else {
			map.put("msg", "loginFaild");
		}
		
		return map;
	}

}
