package com.wangrui.myblog.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;



public class CharsetFilter implements Filter {

	private String charSet = null;
  
	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    request.setCharacterEncoding(charSet);
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig config) throws ServletException {
		this.charSet = config.getInitParameter("charSet");// 取出初始化参数指定的字符集
	}

}
