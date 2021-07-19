package com.wangrui.tsd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.wangrui.tsd.bean.Knowledge;
import com.wangrui.tsd.bean.Recomment;
import com.wangrui.tsd.bean.User;

@Repository
@Mapper
public interface KnowledgeDao {

	
	@Insert("insert into t_knowledge(knowledge_id, abstract, content, picture, user_id) "
			+ "values (#{knowledgeID}, #{abs}, #{content}, #{picture}, #{user.userID})")
	@SelectKey(before = true, keyProperty = "knowledgeID", resultType = Integer.class,
	           statement = { "select seq_knowledge.nextval from dual" })
	public void add(Knowledge k);
	
	
	@Select("select * from (" + 
			"select a.* ,rownum ro from(" + 
			"select * from t_knowledge order by knowledge_id desc)a  where rownum <=${page*size}) where ro >${(page-1)*size}")
	@Results(id = "KnowledgeMpper", value = {@Result(column = "knowledge_id", property = "knowledgeID", id = true),
			                                 @Result(column = "abstract", property = "abs"),
			                                 @Result(column = "content", property = "content"),
			                                 @Result(column = "picture", property = "picture"),
			                                 @Result(column = "user_id", property = "user", javaType = User.class,
			                                 one= @One(select = "com.wangrui.tsd.dao.UserDao.findByID")),
			                                 @Result(column = "knowledge_id", property = "lastRecomment", javaType = Recomment.class, 
			                                 one = @One(select = "com.wangrui.tsd.dao.RecommentDao.lastRecomment"))
	                                         })
	public List<Knowledge> list(@Param("page")int page, @Param("size")int size);
	
	@Select("select count(*) from t_knowledge")
	public int totalCount();
	
	@Select("select * from t_knowledge where knowledge_id=#{id}")
	@ResultMap("KnowledgeMpper")
	public Knowledge findByID(int id);
	
}
