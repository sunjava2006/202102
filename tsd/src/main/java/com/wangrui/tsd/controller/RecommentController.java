package com.wangrui.tsd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangrui.tsd.bean.Recomment;
import com.wangrui.tsd.service.RecommentService;

@Controller
public class RecommentController {

	@Autowired
	private RecommentService rs;
	
	@RequestMapping("/publishRecomment")
	@ResponseBody
	public Map publish(Recomment r) {
		System.out.println(r);
		Map m = new HashMap();
		try {
			this.rs.publish(r);
			
			m.put("publish","ok");
		} catch (Exception e) {
			e.printStackTrace();
			m.put("publish", "fail");
		}
		
		return m;
	}
	
	@RequestMapping("/listRecomment")
	@ResponseBody
	public Map listRecomment(int page, int size, int knowledgeID, Map map) {
		Map m= new HashMap();
		
		List<Recomment> list = this.rs.listByKnowledge(knowledgeID, page, size);
		int totalPage = rs.totalPage(knowledgeID, size);
		
		m.put("list", list);
		m.put("totalPage", totalPage);
		m.put("currPage", page);
		
		return m;
	}
}
