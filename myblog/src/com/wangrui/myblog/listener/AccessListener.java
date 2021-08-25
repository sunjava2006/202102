package com.wangrui.myblog.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class AccessListener implements HttpSessionListener {

  
	// 有一个新的session对象创建时调用
    public void sessionCreated(HttpSessionEvent se)  { 
         HttpSession session = se.getSession();
         ServletContext application = session.getServletContext();
         int count = (Integer)application.getAttribute("accessCount");
         application.setAttribute("accessCount", ++count);
         
         int currentCount = (Integer)application.getAttribute("currentCount");
         application.setAttribute("currentCount", ++currentCount);
         
    }

	// 有一个会话失效时调用
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	 HttpSession session = se.getSession();
         ServletContext application = session.getServletContext();
       
         
         int currentCount = (Integer)application.getAttribute("currentCount");
         application.setAttribute("currentCount", --currentCount);
    }
	
}
