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
				
				// ȡ���������
				String loginName = request.getParameter("loginName");
				String pwd = request.getParameter("pwd");
				User u = null;
				Blog b = null;
				try {
					u = us.login(loginName, pwd);
					if(u!= null) {
						// �ٲ�ѯһ���Ƿ��в���
						BlogService bs = new BlogService();
						b = bs.findBlog(u.getUserID());
						session.setAttribute("blogInfo", b);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("msg", "��¼ʧ��");  // ������������е�����
					request.getRequestDispatcher("/Logon.jsp").forward(request, response);
					return;
				} 
				if(u==null) { // ��¼���ɹ�
					request.setAttribute("msg", "��¼�������벻��ȷ");  // ������������е�����
					request.getRequestDispatcher("/Logon.jsp").forward(request, response);
				}else {//��¼�ɹ�
					String auto = request.getParameter("autoLogon");
					
					session.setAttribute("userInfo", u);
					response.sendRedirect("/");
				}
				
				
				
			}else { // ��֤�벻��
				request.setAttribute("msg", "��֤�벻��ȷ");  // ������������е�����
				request.getRequestDispatcher("/Logon.jsp").forward(request, response);
			}
		}else {// Session��û����֤��
			response.sendRedirect("/Logon.jsp");
		}
	}

}
