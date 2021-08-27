package com.wangrui.myblog.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangrui.myblog.bean.Blog;
import com.wangrui.myblog.bean.Type;
import com.wangrui.myblog.dao.BlogDao;
import com.wangrui.myblog.dao.JdbcTemplate;
import com.wangrui.myblog.dao.ResultSetExtrector;

public class BlogService {

	public Blog findBlog(int userID) throws SQLException {
		BlogDao dao = new BlogDao();
		return dao.findByUserID(userID);
	}
	
	public Blog findBlogByID(int blogID) throws SQLException {
		BlogDao dao = new BlogDao();
		return dao.findByUserID(blogID);
	}
	
	public Blog apply(String blogName, String nickName, String photo, int userID) throws SQLException {
		BlogDao dao = new BlogDao();
		return dao.add(blogName, nickName, photo, userID);
	}
	
	public int totalArticleCount(int blogID) throws SQLException {
		BlogDao dao = new BlogDao();
		return dao.totalArticleCount(blogID);
	}
	
	
	/**
	 * 查询出指定博客的文章，所引用到的文章的分类
	 * @param blogID
	 * @return
	 * @throws SQLException
	 */
	public List<Type> refAllType(int blogID) throws SQLException{
		BlogDao dao = new BlogDao();
		return dao.refAllType(blogID);
	}
	
	/**
	 * 查询指定博客所有文章的总访问数
	 * @param blogID
	 * @return文章的总访问数
	 * @throws SQLException
	 */
	public int articleTotalAccessCount(int blogID) throws SQLException {
		BlogDao dao = new BlogDao();
		return dao.articleTotalAccessCount(blogID);
	}
	
	
	/**
	 * 查询指定博客的文章的总评论数
	 * @param blogID
	 * @return
	 * @throws SQLException
	 */
	public int articleTotalReviewCount(int blogID) throws SQLException {
		BlogDao dao = new BlogDao();
		return dao.articleTotalReviewCount(blogID);
	}
	
}
