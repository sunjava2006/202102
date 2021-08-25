package com.wangrui.myblog.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class AccessListener implements HttpSessionListener {

  
	// ��һ���µ�session���󴴽�ʱ����
    public void sessionCreated(HttpSessionEvent se)  { 
         HttpSession session = se.getSession();
         ServletContext application = session.getServletContext();
         int count = (Integer)application.getAttribute("accessCount");
         application.setAttribute("accessCount", ++count);
         
         int currentCount = (Integer)application.getAttribute("currentCount");
         application.setAttribute("currentCount", ++currentCount);
         
    }

	// ��һ���ỰʧЧʱ����
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	 HttpSession session = se.getSession();
         ServletContext application = session.getServletContext();
       
         
         int currentCount = (Integer)application.getAttribute("currentCount");
         application.setAttribute("currentCount", --currentCount);
    }
	
}
