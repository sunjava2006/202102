package com.wangrui.myblog.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangrui.myblog.bean.User;
import com.wangrui.myblog.service.UserService;

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
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(true);
		Object o = session.getAttribute("code");
		if(o != null) {
			String scode = (String) o;
			String code = request.getParameter("code");
			if(scode.equals(code)) {
				// 从request中获取参数
				String loginName = req.getParameter("loginName");
				String pwd = req.getParameter("pwd");
				String email = req.getParameter("email");
				String question = req.getParameter("question");
				String answer = req.getParameter("answer");
				
				UserService us = new UserService();
				User u = null;
				try {
					u = us.regist(loginName, pwd, email, question, answer);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(u!=null) { // 注册成功，转向注册成功页面
					req.getRequestDispatcher("/reg2email.html").forward(req, res);
					
				}else { // 回到登录页面，提示失败重试。
					
				}
			}else {
				request.setAttribute("msg", "验证码不正确");
				request.getRequestDispatcher("/Login.jsp").forward(request, res);
			}
		}else {
			HttpServletResponse response = (HttpServletResponse)res;
			response.sendRedirect("/Login.jsp");
		}
		
		
		
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
