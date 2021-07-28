package com.wangrui.tsd.configuration;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterreptor implements HandlerInterceptor {

	@Override // preHandle 在Controller之前运行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("===============preHandle==================");
		HttpSession session = request.getSession(true);
		
		if(null != session.getAttribute("userInfo")) {
			return true; // 放行
		}else {
			System.out.println("没有登录 ，非法访问管理员页面");
			response.sendRedirect("/");  // 重定向到登录页面
			return false; // 返回false禁止向后继续访问Controller。
		}
	}

	@Override // 在Controller运行之后运行
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("=================postHandle==================");
		
		Enumeration<String> names = request.getAttributeNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println("my-------------"+name+":"+request.getAttribute(name));
		}
		
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override // 在返回之后执行
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("=============afterCompletion==============");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
