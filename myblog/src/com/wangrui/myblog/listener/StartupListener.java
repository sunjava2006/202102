package com.wangrui.myblog.listener;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class StartupListener implements ServletContextListener {

  
	// 监听到ServetContext对象创建之后运行
	public void contextInitialized(ServletContextEvent sce)  { 
		ServletContext application = sce.getServletContext();
		FileInputStream in = null;
		
		InputStreamReader inReader = null;
		BufferedReader bufReader = null;

		
		try {
			String path = application.getRealPath("/count.txt");
			in = new FileInputStream(path);
			inReader = new InputStreamReader(in);
			bufReader = new BufferedReader(inReader);
			String str = bufReader.readLine();
			
			System.out.println("init count"+str);
			
			application.setAttribute("accessCount", Integer.parseInt(str));
			application.setAttribute("currentCount", 0);
			application.setAttribute("loginUsers", new ArrayList());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(null != bufReader) {
					bufReader.close();
				}
				if(null != inReader) {
					inReader.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
    }
	
	// 监听到用户关闭时运行
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("===================服务停止=======================");
    	ServletContext application = sce.getServletContext();
    	String path = application.getRealPath("/count.txt");
    	System.out.println(path);
    	int count = (Integer)application.getAttribute("accessCount");
    	String s = String.valueOf(count);
    	FileWriter out = null;
    	
    	try {
			out = new FileWriter(path);
			
			out.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
					
				}
			}
		}
    
    }

	
   
	
}
