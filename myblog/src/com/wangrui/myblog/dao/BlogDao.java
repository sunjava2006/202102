package com.wangrui.myblog.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangrui.myblog.bean.Blog;
import com.wangrui.myblog.bean.Type;

public class BlogDao {

	public Blog findByUserID(int userID) throws SQLException {
		Blog b = null;
		
		String sql = "select * from t_blog where user_id=?";
		ResultSetExtrector<Blog> ext = (rst)->{
			Blog bb = null;
			if(rst.next()) {
				int blogID = rst.getInt("blog_id");
				String blogName = rst.getString("blog_name");
				String nickName = rst.getString("nick_name");
				String photo = rst.getString("photo");
				
				bb = new Blog(blogID, blogName, nickName, userID, photo);
			}
			return bb;
		};
		
		JdbcTemplate tmp = new JdbcTemplate();
		b = tmp.select(sql, ext, userID);
		
		return b;
	}
	
	
	public Blog findByBlogID(int blogID) throws SQLException {
		Blog b = null;
		
		String sql = "select * from t_blog where blog_id=?";
		ResultSetExtrector<Blog> ext = (rst)->{
			Blog bb = null;
			if(rst.next()) {
				
				String blogName = rst.getString("blog_name");
				String nickName = rst.getString("nick_name");
				String photo = rst.getString("photo");
				int userID = rst.getInt("user_id");
				bb = new Blog(blogID, blogName, nickName, userID, photo);
			}
			return bb;
		};
		
		JdbcTemplate tmp = new JdbcTemplate();
		b = tmp.select(sql, ext, blogID);
		
		return b;
	}
	
	
	public Blog add(String blogName, String nickName, String photo, int userID) throws SQLException {
		
		Blog b = null;
		
		// ��ȡ blogID
		String idsql = "select seq_blog.nextval from dual";
		ResultSetExtrector<Integer> ext = (rst)->{
			Integer i = null;
			if(rst.next()) {
				i = rst.getInt(1);
			}
			return i;
		};
		
		JdbcTemplate tmp = new JdbcTemplate();
		Integer blogID = tmp.select(idsql, ext);
		if(blogID != null) {
			
			String sql = "insert into t_blog(blog_id, blog_name, nick_name, photo, user_id) values(?,?,?,?,?)";
			int count = tmp.cud(sql, blogID, blogName, nickName, photo, userID);
			if(1==count) {
				b = new Blog(blogID, blogName, nickName, userID, photo);
			}
			
		}

		return b;
		
	}
	
	
	/****************************************************
	 * 我的博客中的统计查询
	 ****************************************************/
	/**
	 * 查询指定博客的总文章数
	 * @param blogID
	 * @return 总文章数
	 * @throws SQLException 
	 */
	public int totalArticleCount(int blogID) throws SQLException {
		int count = 0;
		String sql = "select count(*)from t_article where blog_id=?";
		
		ResultSetExtrector<Integer> ext = (rst)->{
			int c = 0;
			rst.next();
			c = rst.getInt(1);
			return c;
		};
		
		JdbcTemplate tmp = new JdbcTemplate();
		count = tmp.select(sql, ext, blogID);
		return count;
	}
	
	
	/**
	 * 查询出指定博客的文章，所引用到的文章的分类
	 * @param blogID
	 * @return
	 * @throws SQLException
	 */
	public List<Type> refAllType(int blogID) throws SQLException{
		List<Type> li = null;
		
		String sql = "select * from t_type where type_id in (select type_id from t_article where blog_id=?)";
		ResultSetExtrector<List<Type>> ext = (rst)->{
			List<Type> list = new ArrayList<>();
			while(rst.next()) {
				int typeID = rst.getInt("type_id");
				String typeName = rst.getString("type_name");
				Type type = new Type(typeID, typeName);
				list.add(type);
			}
			return list;
		};
		
		JdbcTemplate tmp = new JdbcTemplate();
		li = tmp.select(sql, ext, blogID);
		
		return li;
	}
	
	/**
	 * 查询指定博客所有文章的总访问数
	 * @param blogID
	 * @return文章的总访问数
	 * @throws SQLException
	 */
	public int articleTotalAccessCount(int blogID) throws SQLException {
		int count = 0;
		String sql = "select sum(nvl(access_count,0))from t_article where blog_id=?";
		
		ResultSetExtrector<Integer> ext = (rst)->{
			int c = 0;
			rst.next();
			c = rst.getInt(1);
			return c;
		};
		
		JdbcTemplate tmp = new JdbcTemplate();
		count = tmp.select(sql, ext, blogID);
		return count;
	}
	
	
	/**
	 * 查询指定博客的文章的总评论数
	 * @param blogID
	 * @return
	 * @throws SQLException
	 */
	public int articleTotalReviewCount(int blogID) throws SQLException {
		int count = 0;
		String sql = "select count(*)from t_review where article_id in "
				+ "( select article_id from t_article where blog_id=?)";
		
		ResultSetExtrector<Integer> ext = (rst)->{
			int c = 0;
			rst.next();
			c = rst.getInt(1);
			return c;
		};
		
		JdbcTemplate tmp = new JdbcTemplate();
		count = tmp.select(sql, ext, blogID);
		return count;
	}
	
	
}
