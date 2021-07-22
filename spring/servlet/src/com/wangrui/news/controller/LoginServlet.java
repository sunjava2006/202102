package com.wangrui.news.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

public class LoginServlet implements Servlet{


	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override  
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("-------------================------------");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		
		System.out.println(name + ", " + pwd);
		
		res.getWriter().print("hello world");
		
	}
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
