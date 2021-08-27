package com.wangrui.myblog.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.wangrui.myblog.bean.Article;

public class ArticleDao {

	
	public static int publish(int blogID, String title, String content, int typeID) throws SQLException {
		int count = 0;
		String sql = "insert into t_article(article_id, blog_id, type_id, title, content) values (seq_article.nextval,?,?,?,?)";
		
		JdbcTemplate tmp = new JdbcTemplate();
		count = tmp.cud(sql, blogID, typeID, title, content);
		return count;
	}
	
	public static List<Article> listByPage(int page, int size, int blogID) throws SQLException{
		List<Article> list = null;
		
		String sql = "select * from(" + 
				"select a.*, rownum ro from(" + 
				"select * from t_article where blog_id=? order by article_id desc)a where rownum <=?)" + 
				"where ro>?";
		
		ResultSetExtrector<List<Article>> ext = (rst)->{
			List<Article> li = new ArrayList<>();
			
			while(rst.next()) {
				int articleID = rst.getInt("article_id");
				String title = rst.getString("title");
				String content = rst.getString("content");
				Date publishDate = rst.getDate("publish_date");
				int accessCount = rst.getInt("access_count");
				int typeID = rst.getInt("type_id");
				
				li.add(new Article(articleID, blogID, title, content, publishDate, accessCount, typeID));
				
			}
			
			return li;
		};
		
		JdbcTemplate tmp = new JdbcTemplate();
		list = tmp.select(sql, ext, blogID, page*size, (page-1)*size);
		
		
		return list;
	}
	
	
	public static int delAritcle(int articleID) throws SQLException {
		String sql = "delete from t_article where article_id=?";
		JdbcTemplate tmp = new JdbcTemplate();
		return tmp.cud(sql, articleID);
	}
}
