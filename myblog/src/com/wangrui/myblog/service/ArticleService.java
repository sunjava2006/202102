package com.wangrui.myblog.service;

import java.sql.SQLException;
import java.util.List;

import com.wangrui.myblog.bean.Article;
import com.wangrui.myblog.dao.ArticleDao;

public class ArticleService {

	public static void publish(int blogID, String title, String content, int typeID) throws SQLException {
		ArticleDao.publish(blogID, title, content, typeID);
	}
	
	public static List<Article> listByPage(int page, int size, int blogID) throws SQLException{
		return ArticleDao.listByPage(page, size, blogID);
	}
	
	public static int articleCount(int blogID) throws SQLException {
		BlogService bs = new BlogService();
		return bs.totalArticleCount(blogID);
	}
	
	public static int totalPage(int articleCount, double size) {
		return (int)(Math.ceil(articleCount/size));
	}
	
	public static int delAritcle(int articleID) throws SQLException {
		return ArticleDao.delAritcle(articleID);
	}
}
