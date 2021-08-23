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
		System.out.println("-----------协议-----------");
		System.out.println(request.getMethod()); // GET / POST
		System.out.println(request.getProtocol()); // HTTP/1.1
		System.out.println(request.getScheme()); // http
		System.out.println("---------------浏览器端信息--------------");
		System.out.println(request.getRemoteAddr()); // 0:0:0:0:0:0:0:1
		System.out.println(request.getRemoteHost()); // 0:0:0:0:0:0:0:1
		System.out.println(request.getRemotePort()); // 64057
		System.out.println(request.getRemoteUser()); // null CGI 验证的用户
		System.out.println("----------- url-----------");
		System.out.println(request.getRequestURI()); // /test
		System.out.println(request.getRequestURL()); // http://localhost:8088/test
		
		System.out.println(request.getContextPath()); // 在服务器中访问不同应用的上下文。
		System.out.println("---------------请求参数--------------");
		System.out.println(request.getQueryString()); //Get 指通过url方式发送的请求参数
		System.out.println(request.getContentLength()); // POST 发送的数据的长度
		System.out.println(request.getContentLengthLong()); // POST 发送的数据的长度
		System.out.println(request.getContentType()); //  form表单发送数据的请求类型：application/x-www-form-urlencoded
		
		
		System.out.println("----------------请求头---------------");
		System.out.println(request.getHeader("Content-Type"));//application/x-www-form-urlencoded
		System.out.println(request.getHeader("Content-Length"));
		
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()) {
			String headerName = headers.nextElement();
			System.out.println(headerName+":"+request.getHeader(headerName));
		}
		
		System.out.println("-----------------参数----------------");
		System.out.println(request.getParameter("a"));  // 获取有一个值的参数值 。
		System.out.println(request.getParameter("b"));
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String name = paramNames.nextElement();
			System.out.println(name + ":" + request.getParameter(name));
		}
		String[] likes = request.getParameterValues("interesting"); // 获取有多个值的参数值。
		System.out.println(Arrays.toString(likes)); // 
	
		
//		response.setStatus(302); // 直接设置响应，进行重定向
//		response.addHeader("Location", "http://www.sina.com.cn");
		
		
//		response.sendRedirect("http://www.qq.com");
		
		// 直接设置响应头， 返回内容。
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
