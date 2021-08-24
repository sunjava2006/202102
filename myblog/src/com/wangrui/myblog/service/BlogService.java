package com.wangrui.myblog.service;

import java.sql.SQLException;

import com.wangrui.myblog.bean.Blog;
import com.wangrui.myblog.dao.BlogDao;

public class BlogService {

	public Blog findBlog(int userID) throws SQLException {
		BlogDao dao = new BlogDao();
		return dao.findByUserID(userID);
	}
	
	public Blog apply(String blogName, String nickName, String photo, int userID) throws SQLException {
		BlogDao dao = new BlogDao();
		return dao.add(blogName, nickName, photo, userID);
	}
}
