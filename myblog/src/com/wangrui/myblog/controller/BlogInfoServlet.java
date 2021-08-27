package com.wangrui.myblog.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangrui.myblog.bean.Blog;
import com.wangrui.myblog.bean.Type;
import com.wangrui.myblog.service.BlogService;


@WebServlet("/blogInfo")
public class BlogInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		Blog b = (Blog)session.getAttribute("blogInfo");
		
		BlogService bs = new BlogService();
		
		try {
			int totalArticleCount =  bs.totalArticleCount(b.getBlogID());
			int articleTotalAccessCount = bs.articleTotalAccessCount(b.getBlogID());
			int articleTotalReviewCount = bs.articleTotalReviewCount(b.getBlogID());
			List<Type> types = bs.refAllType(b.getBlogID());
			
			request.setAttribute("types", types);
			request.setAttribute("articleTotalReviewCount", articleTotalReviewCount);
			request.setAttribute("articleTotalAccessCount", articleTotalAccessCount);
			request.setAttribute("totalArticleCount", totalArticleCount);
			
			request.getRequestDispatcher("/BlogInfo.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
