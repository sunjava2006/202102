package com.wangrui.myblog.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/regist", loadOnStartup = 1)
public class RegistServlet implements Servlet{

	public RegistServlet() {
	   System.out.println("RegistServlet create");	
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("------init------");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println(Thread.currentThread().getName()+"=======service=======");
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
	public void destroy() {
		System.out.println("-----destroy----");
	}

}
