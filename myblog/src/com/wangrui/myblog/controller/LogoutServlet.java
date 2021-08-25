package com.wangrui.myblog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.removeAttribute("userInfo");
		
		session.removeAttribute("blogInfo");
		
		Cookie c1 = new Cookie("loginName", null);
		Cookie c2 = new Cookie("pwd", null);
		c1.setMaxAge(0);
		c2.setMaxAge(0);
		
		response.addCookie(c1);
		response.addCookie(c2);
		
		response.sendRedirect("/");
	}

}
