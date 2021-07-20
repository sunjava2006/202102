package com.wangrui.tsd.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FocusController {
	
	@RequestMapping(value="/list", method = {RequestMethod.DELETE},
			        params = {"name","password"})
//	@PostMapping("/list") //  @RequestMapping + method=POST
//	@GetMapping("/list")  //  @RequestMapping + method=GET
	@ResponseBody
	public String list(String name, @RequestParam("password") String pwd,
			          @CookieValue(value="name", required = false) String uname, 
			          HttpServletResponse res) {
		
		Cookie c = new Cookie("name", "wang");
		c.setMaxAge(24*60*60);
		res.addCookie(c);
		
		System.out.println(name);
		System.out.println(pwd);
		System.out.println(uname);
		return "Hello";
	}

}
