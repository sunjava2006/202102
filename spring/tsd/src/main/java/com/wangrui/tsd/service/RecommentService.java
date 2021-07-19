package com.wangrui.tsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.tsd.bean.Recomment;
import com.wangrui.tsd.dao.RecommentDao;

@Service
public class RecommentService {

	@Autowired
	private RecommentDao rdao;
	
	public void publish(Recomment r) {
		this.rdao.add(r);
	}
	
	public List<Recomment> listByKnowledge(int knowledgeID, int page, int size) {
		return this.rdao.listByKnowledge(knowledgeID, page, size);
	}
	
	public int recommentCount(int knowledgeID) {
		return this.rdao.recommentCount(knowledgeID);
	}
	
	public int totalPage(int knowledgeID, double size) {
	  return (int)(Math.ceil( this.recommentCount(knowledgeID)/size));
	}
}
