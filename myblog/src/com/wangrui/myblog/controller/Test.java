package com.wangrui.myblog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;


@WebServlet("/test")
public class Test extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------Э��-----------");
		System.out.println(request.getMethod()); // GET / POST
		System.out.println(request.getProtocol()); // HTTP/1.1
		System.out.println(request.getScheme()); // http
		System.out.println("---------------���������Ϣ--------------");
		System.out.println(request.getRemoteAddr()); // 0:0:0:0:0:0:0:1
		System.out.println(request.getRemoteHost()); // 0:0:0:0:0:0:0:1
		System.out.println(request.getRemotePort()); // 64057
		System.out.println(request.getRemoteUser()); // null CGI ��֤���û�
		System.out.println("----------- url-----------");
		System.out.println(request.getRequestURI()); // /test
		System.out.println(request.getRequestURL()); // http://localhost:8088/test
		
		System.out.println(request.getContextPath()); // �ڷ������з��ʲ�ͬӦ�õ������ġ�
		System.out.println("---------------�������--------------");
		System.out.println(request.getQueryString()); //Get ָͨ��url��ʽ���͵��������
		System.out.println(request.getContentLength()); // POST ���͵����ݵĳ���
		System.out.println(request.getContentLengthLong()); // POST ���͵����ݵĳ���
		System.out.println(request.getContentType()); //  form���������ݵ��������ͣ�application/x-www-form-urlencoded
		
		
		System.out.println("----------------����ͷ---------------");
		System.out.println(request.getHeader("Content-Type"));//application/x-www-form-urlencoded
		System.out.println(request.getHeader("Content-Length"));
		
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()) {
			String headerName = headers.nextElement();
			System.out.println(headerName+":"+request.getHeader(headerName));
		}
		
		System.out.println("-----------------����----------------");
		System.out.println(request.getParameter("a"));  // ��ȡ��һ��ֵ�Ĳ���ֵ ��
		System.out.println(request.getParameter("b"));
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String name = paramNames.nextElement();
			System.out.println(name + ":" + request.getParameter(name));
		}
		String[] likes = request.getParameterValues("interesting"); // ��ȡ�ж��ֵ�Ĳ���ֵ��
		System.out.println(Arrays.toString(likes)); // 
	
		
//		response.setStatus(302); // ֱ��������Ӧ�������ض���
//		response.addHeader("Location", "http://www.sina.com.cn");
		
		
//		response.sendRedirect("http://www.qq.com");
		
		// ֱ��������Ӧͷ�� �������ݡ�
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<http><body><h1>hi</h1>");
		out.print("</body></http>");
		out.flush();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
