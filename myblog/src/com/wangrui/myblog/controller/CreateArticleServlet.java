package com.wangrui.myblog.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangrui.myblog.service.TypeService;


@WebServlet("/createArticle")
public class CreateArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("typeList", TypeService.ListType());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/CreateArticle.jsp").forward(request, response);
	}

}
