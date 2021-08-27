package com.wangrui.myblog.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangrui.myblog.service.ArticleService;


@WebServlet("/delArticle")
public class DelArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int articleID = Integer.parseInt(request.getParameter("articleID"));
		String page = request.getParameter("page");
		String size = request.getParameter("size");
		
		try {
			ArticleService.delAritcle(articleID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 返回文章维护页面
		response.sendRedirect("/manageArticle?page="+page+"&size="+size);
	}

}
