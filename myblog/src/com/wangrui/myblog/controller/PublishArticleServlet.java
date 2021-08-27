package com.wangrui.myblog.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangrui.myblog.bean.Blog;
import com.wangrui.myblog.service.ArticleService;


@WebServlet("/publishArticle")
public class PublishArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int typeID = Integer.parseInt(request.getParameter("typeID"));
		
		HttpSession session = request.getSession(true);
		Object o = session.getAttribute("blogInfo");
		if(null != o) {
			Blog b = (Blog) o;
			// 发表文章
			try {
				ArticleService.publish(b.getBlogID(), title, content, typeID);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			// 返回文章维护页面
			response.sendRedirect("/manageArticle?page=1&size=2");
			
		}else {
			response.setCharacterEncoding("utf-8");
			
			response.getWriter().print("请重新登录");
		}
		
		
	}

}
