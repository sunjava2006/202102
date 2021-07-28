package com.wangrui.tsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wangrui.tsd.bean.Knowledge;
import com.wangrui.tsd.service.KnowledgeService;

@Controller
@RequestMapping("/manage")
public class ManagController {
	@Value("${pageSize}")
	int pageSize;
	
	@Autowired
	private KnowledgeService knowledgeService;
	
	@GetMapping("/Knowledge/{page}/{size}")
	public ModelAndView listKnowledge(@PathVariable("page")int page, 
			                          @PathVariable("size")int size, 
			                          ModelAndView mv) {
		
		List<Knowledge> list = this.knowledgeService.listByPage(page, size);
		
		mv.addObject("list", list);
		mv.addObject("totalPage", this.knowledgeService.totalPage(size));
		mv.addObject("currPage", page);
		mv.addObject("size", size);
		
		mv.setViewName("/knowledgeList");
		
		return mv;
	}
	
	@RequestMapping("/deleteKnowledge/{id}")
	public String deleteKnowledge(@PathVariable("id")int id) {
		
		this.knowledgeService.deleteByID(id);
		
		return "redirect:/manage/Knowledge/1/"+this.pageSize;
	}
	
	

}
