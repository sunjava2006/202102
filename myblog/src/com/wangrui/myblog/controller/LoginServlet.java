package com.wangrui.myblog.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangrui.myblog.bean.Blog;
import com.wangrui.myblog.bean.User;
import com.wangrui.myblog.service.BlogService;
import com.wangrui.myblog.service.UserService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		
		
		Object o = session.getAttribute("code");
		if(o != null) {
			String scode = (String)o;
			String code = request.getParameter("code");
			if(scode.equals(code)) {
				UserService us = new UserService();
				
				// 取出请求参数
				String loginName = request.getParameter("loginName");
				String pwd = request.getParameter("pwd");
				User u = null;
				Blog b = null;
				try {
					u = us.login(loginName, pwd);
					if(u!= null) {
						// 再查询一下是否有博客
						BlogService bs = new BlogService();
						b = bs.findBlog(u.getUserID());
						session.setAttribute("blogInfo", b);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("msg", "登录失败");  // 共享这次请求中的数据
					request.getRequestDispatcher("/Logon.jsp").forward(request, response);
					return;
				} 
				if(u==null) { // 登录不成功
					request.setAttribute("msg", "登录名或密码不正确");  // 共享这次请求中的数据
					request.getRequestDispatcher("/Logon.jsp").forward(request, response);
				}else {//登录成功
					String auto = request.getParameter("autoLogon");
					
					session.setAttribute("userInfo", u);
					response.sendRedirect("/");
				}
				
				
				
			}else { // 验证码不等
				request.setAttribute("msg", "验证码不正确");  // 共享这次请求中的数据
				request.getRequestDispatcher("/Logon.jsp").forward(request, response);
			}
		}else {// Session中没有验证码
			response.sendRedirect("/Logon.jsp");
		}
	}

}
