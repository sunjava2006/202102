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

import com.wangrui.myblog.bean.Article;
import com.wangrui.myblog.bean.Blog;
import com.wangrui.myblog.service.ArticleService;


@WebServlet("/manageArticle")
public class ManageArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Object o = session.getAttribute("blogInfo");
		if(null!=o) {
			Blog b = (Blog) o;
			int page = Integer.parseInt(request.getParameter("page"));
			int size = Integer.parseInt(request.getParameter("size"));
			
			try {
				int totalCount = ArticleService.articleCount(b.getBlogID());
				List<Article> list = ArticleService.listByPage(page, size, b.getBlogID());
				request.setAttribute("list", list);
				request.setAttribute("currPage", page);
				request.setAttribute("totalPage", ArticleService.totalPage(totalCount, size));
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("/ManageArticle.jsp").forward(request, response);
		}else {
			response.setCharacterEncoding("utf-8");
			
			response.getWriter().print("请重新登录");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
