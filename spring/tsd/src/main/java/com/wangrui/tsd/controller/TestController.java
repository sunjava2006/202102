package com.wangrui.tsd.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/test")
	// 返回String 的方法，会将String看能是ModelAndView的ViewName
	public String a(@ModelAttribute("name")String username, ModelAndView mv, Map m) {
//		mv.addObject("xx", "13579");
//		m.addAttribute("xx", "123");
		m.put("xx", "45678");
		return "test";
//		return mv;
	}
	
	@RequestMapping("/testlogin")
	@ResponseBody
	@CrossOrigin(originPatterns = {"http://127.0.0.1:5500"})
	public String testLogin(String loginName, String pwd,
			                HttpServletResponse res) {
		
//		res.setHeader("Access-Control-Allow-Origin", "*");
		
		return "OK";
	}
	
	@Value("${server.port}")
	int port;
	
	@RequestMapping("/xxx")
	public void test(PrintWriter p) {
		p.print(port);
	}
}
