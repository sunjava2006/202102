package com.wangrui.myblog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangrui.myblog.service.UserService;


@WebServlet("/ValidateLoginName")
public class ValidateLoginNameServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginName = request.getParameter("loginName");
		
		UserService us = new UserService();
		boolean ok = false;
		try {
			ok = us.loginNameUnique(loginName);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		response.setHeader("Content-type", "application/text/html");
		if(ok) {
			PrintWriter out = response.getWriter();
			out.print("ok");
		}else {
			PrintWriter out = response.getWriter();
			out.print("nook");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
