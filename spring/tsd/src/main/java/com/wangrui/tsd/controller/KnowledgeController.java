package com.wangrui.tsd.controller;import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wangrui.tsd.bean.Knowledge;
import com.wangrui.tsd.service.KnowledgeService;

@Controller
public class KnowledgeController {

	@Autowired
	private KnowledgeService ks;
	
	
	@RequestMapping("/publishKnowledge")
	@ResponseBody
	public Map publish(MultipartFile pic, Knowledge k) {
		Map<String, Object> m = new HashMap<>();
		
		try {
			String fileName = pic.getOriginalFilename();
			String uploadPath = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"static/pictures";
			File dir = new File(uploadPath);
			
			if(! dir.exists()) {
				dir.mkdirs();
			}
			
			pic.transferTo(new File(dir, fileName) );
			
			k.setPicture(fileName);
			System.out.println(k);
			
			ks.publish(k);
			
			m.put("success", true);
			
		} catch (Exception e) {
			e.printStackTrace();
			m.put("success", false);
		}
		
		return m;
	}
	
	@RequestMapping("/listKnowledge")
	@ResponseBody
	public Map list(@RequestBody Map m){
		Map map = new HashMap<>();
		
		List<Knowledge> list = this.ks.listByPage((Integer)m.get("page"), (Integer)m.get("size"));
		int totalPage  = this.ks.totalPage((Integer)m.get("size"));
		
		map.put("totalPage", totalPage);
		map.put("currPage", (Integer)m.get("page"));
		map.put("list", list);
		
	
		return map;
	}
	
}
