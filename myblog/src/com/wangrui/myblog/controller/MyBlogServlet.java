package com.wangrui.myblog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangrui.myblog.bean.Blog;
import com.wangrui.myblog.service.BlogService;


@WebServlet("/myBlog")
public class MyBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Object o = session.getAttribute("blogInfo");
		if(null != o) {
			Blog b = (Blog)o;
			
			request.getRequestDispatcher("/MyBlog.jsp").forward(request, response);
			
		}else {
			response.sendRedirect("/Logon.jsp"); // 用户Session中没有博客信息，重定向到登录页面
		}
		
	}

}
