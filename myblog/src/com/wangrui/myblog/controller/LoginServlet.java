package com.wangrui.myblog.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangrui.myblog.bean.User;
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
				
				try {
					u = us.login(loginName, pwd);
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("msg", "��¼ʧ��");  // ������������е�����
					request.getRequestDispatcher("/Logon.jsp").forward(request, response);
				} 
				if(u==null) { // ��¼���ɹ�
					request.setAttribute("msg", "��¼�������벻��ȷ");  // ������������е�����
					request.getRequestDispatcher("/Logon.jsp").forward(request, response);
				}else {//��¼�ɹ�
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
