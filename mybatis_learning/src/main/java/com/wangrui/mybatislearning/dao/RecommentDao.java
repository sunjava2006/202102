package com.wangrui.mybatislearning.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.wangrui.mybatislearning.bean.Recomment;
import com.wangrui.mybatislearning.bean.User;



@Mapper

public interface RecommentDao {

	@Insert("insert into t_recomment(recomment_id, knowledge_id, user_id, content, grad) "
			+ "values (#{recommentID}, #{knowledgeID}, #{user.userID}, #{content}, #{grad})")
	@SelectKey( before = true, keyProperty = "recommentID", resultType = Integer.class, 
	            statement = { "select seq_recomment.nextval from dual" })
	public void add(Recomment r);
	
	@Select("select * from (" + 
			"select a.*, rownum ro from(" + 
			"select * from t_recomment where knowledge_id=#{knowledgeID} order by recomment_id desc)a where rownum <=${page*size})" + 
			"where ro >${(page-1)*size}")
	@Results(id = "RecommentMapper", value = {  @Result(column = "recomment_id", property = "recommentID", id = true),
												@Result(column = "knowledge_id", property = "knowledgeID"),
												@Result(column = "user_id", property = "user", javaType = User.class,
												        one = @One(select = "com.wangrui.mybatislearning.dao.UserDao.findByID")),
												@Result(column = "content", property = "content"),
												@Result(column = "grad", property = "grad"),
												@Result(column = "publish_date", property = "publishDate")

	                                          })
	public List<Recomment> listByKnowledge(@Param("knowledgeID")int knowledgeID,@Param("page") int page, @Param("size") int size);
	
	@Select("select count(*) from t_recomment where knowledge_id=#{knowledgeID}")
	public int recommentCount(int knowledgeID);
	
	@Select("select a.*, rownum ro from(" + 
			"select * from t_recomment where knowledge_id=#{konwledgeID} order by recomment_id desc)a where rownum =1")
	@ResultMap("RecommentMapper")
	public Recomment lastRecomment(int konwledgeID);
	
	@Delete("delete from t_recomment where knowledge_id=#{knowledgeID}")
	public void deleteByKnowledgeID(int knowledgeID);
	
}
