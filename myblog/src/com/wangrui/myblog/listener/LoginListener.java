package com.wangrui.myblog.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


import com.wangrui.myblog.bean.User;


@WebListener
public class LoginListener implements HttpSessionAttributeListener {

  
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         String attrName = se.getName();
         if("userInfo".equals(attrName)) {
        	 User u = (User) se.getValue();
        	 String loginName = u.getLoginName();
        	 
        	 ServletContext application = se.getSession().getServletContext();
        	 List list = (List) application.getAttribute("loginUsers");
        	 
        	 list.add(loginName);
         }
    }

	
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	String attrName = se.getName();
        if("userInfo".equals(attrName)) {
       	 User u = (User) se.getValue();
       	 String loginName = u.getLoginName();
       	 
       	 ServletContext application = se.getSession().getServletContext();
       	 List list = (List) application.getAttribute("loginUsers");
       	 
       	 list.remove(loginName);
        }
    }

	
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
