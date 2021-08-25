package com.wangrui.myblog.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wangrui.myblog.bean.Blog;
import com.wangrui.myblog.bean.User;
import com.wangrui.myblog.service.BlogService;
import com.wangrui.myblog.service.UserService;


@WebFilter("/*")
public class AutoLoginFilter implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter init");
	}
	

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String loginName =null, pwd = null;
		
		Cookie[] cookies = req.getCookies();
		for(Cookie c: cookies) {
			String name = c.getName();
			if("loginName".equals(name)) {
				loginName = c.getValue();
			}
			if("pwd".equals(name)) {
				pwd = c.getValue();
			}
		}
		
		if(loginName != null && pwd != null) {
			UserService us = new UserService();
			try {
				User u = us.login(loginName, pwd);
				if(u!=null) {
					HttpSession session = req.getSession(true);
					session.setAttribute("userInfo", u);
					
					BlogService bs = new BlogService();
					Blog b = bs.findBlog(u.getUserID());
					session.setAttribute("blogInfo", b);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		// 将请求放行，访问后续资源
		chain.doFilter(request, response);
	}

	
	public void destroy() {
		
	}

}
