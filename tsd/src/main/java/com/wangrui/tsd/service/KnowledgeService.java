package com.wangrui.tsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangrui.tsd.bean.Knowledge;
import com.wangrui.tsd.dao.KnowledgeDao;
import com.wangrui.tsd.dao.RecommentDao;

@Service
public class KnowledgeService {

	@Autowired
	private KnowledgeDao knowledgeDao;
	
	@Autowired
	private RecommentDao recommentDao;
	
	public void publish(Knowledge k) {
		this.knowledgeDao.add(k);
	}
	
	public List<Knowledge> listByPage(int page, int size){
		return this.knowledgeDao.list(page, size);
	}
	
	public int totalCount() {
		return this.knowledgeDao.totalCount();
	}
	
	public int totalPage(double size) {
		int count = this.knowledgeDao.totalCount();
		return (int) Math.ceil(count/size);
	}
	
	public Knowledge findById(int id) {
		return this.knowledgeDao.findByID(id);
	}
	
	@Transactional // 启动事务
	public void deleteByID(int id) {
		this.recommentDao.deleteByKnowledgeID(id);
		this.knowledgeDao.deleteByID(id);
	}
}
