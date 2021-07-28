package com.wangrui.tsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangrui.tsd.bean.Knowledge;
import com.wangrui.tsd.dao.KnowledgeDao;
import com.wangrui.tsd.dao.RecommentDao;

@Service
@CacheConfig(cacheNames = {"c1","c2","c3"})
public class KnowledgeService {

	@Autowired
	private KnowledgeDao knowledgeDao;
	
	@Autowired
	private RecommentDao recommentDao;
	
	public void publish(Knowledge k) {
		this.knowledgeDao.add(k);
	}
	
	@Cacheable
	public List<Knowledge> listByPage(int page, int size){
		return this.knowledgeDao.list(page, size);
	}
    @Cacheable
	public int totalCount() {
		return this.knowledgeDao.totalCount();
	}
    @Cacheable
	public int totalPage(int size) {
		int count = this.knowledgeDao.totalCount();
		return (int) Math.ceil(count/(double)size);
	}
	@Cacheable(key = "#id")
	public Knowledge findById(int id) {
		return this.knowledgeDao.findByID(id);
	}
	
	@Transactional // 启动事务
	@CacheEvict(key = "#id") // 不是对象属性#
	public void deleteByID(int id) {
		this.recommentDao.deleteByKnowledgeID(id);
		this.knowledgeDao.deleteByID(id);
	}
}
