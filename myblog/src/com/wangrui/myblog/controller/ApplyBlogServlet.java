package com.wangrui.myblog.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.wangrui.myblog.bean.Blog;
import com.wangrui.myblog.bean.User;
import com.wangrui.myblog.service.BlogService;


@WebServlet("/applyBlog")
@MultipartConfig
public class ApplyBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
//		request.setCharacterEncoding("utf-8"); // 设置请求的字符编码
		
		HttpSession session = request.getSession(true);
		Object o = session.getAttribute("userInfo");
		if(o!=null) {
			String blogName = null;
			String nickName = null;
			blogName = request.getParameter("blogName");
			nickName = request.getParameter("nickName");
			

			Part p = request.getPart("photo");
			String fileName = p.getSubmittedFileName();
			InputStream in = p.getInputStream();
			String newName = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
			
			
			String path = this.getServletContext().getRealPath("/photos"); // 根据URL，获取物理存储路径。
			System.out.println(path);
			
			FileOutputStream out = null;
			out = new FileOutputStream(path+"/"+newName);
			byte[] buffer = new byte[1024];
			int count = -1;
			
			while(-1 != (count = in.read(buffer))) {
				out.write(buffer, 0, count);
			}
			out.close();
			in.close();
			
			System.out.println(fileName);
			System.out.println("blogName:" + blogName);
			
			//==========================
			BlogService bs = new BlogService();
			
			User u = (User)o;
			Blog b = null;
			try {
				b = bs.apply(blogName, nickName, newName, u.getUserID());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(b!=null) {
				session.setAttribute("blogInfo", b); // 博客信息存储到session
				response.sendRedirect("/");// 也可以转到我的博客
			}else {
				request.setAttribute("msg", "申请博客失败");
				request.getRequestDispatcher("/Apply.jsp").forward(request, response);
			}
		}else {
			response.sendRedirect("/Login.jsp");
		}
		
		

	}

}
