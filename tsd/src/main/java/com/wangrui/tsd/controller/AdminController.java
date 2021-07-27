package com.wangrui.tsd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wangrui.tsd.bean.Admin;
import com.wangrui.tsd.bean.Knowledge;
import com.wangrui.tsd.service.AdminService;
import com.wangrui.tsd.service.KnowledgeService;

@Controller
public class AdminController {
	@Value("${pageSize}")
	int pageSize;
	
	@Autowired
	private AdminService adminService;
	
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
		
		return "redirect:/Knowledge/1/"+this.pageSize;
	}
	
	
	
	@RequestMapping("/")
	public ModelAndView loginPage(HttpSession session) { // 传入的Servlet API
		ModelAndView mv = new ModelAndView();
		String code = (int)(Math.random()*10000)+"";
		
	    session.setAttribute("code", code); // 在session中存储数据（服务器端对象）
		
	    String sessionID = session.getId();
	    System.out.println("sessionId:" + sessionID);
		session.setAttribute(sessionID, code);
		
		
		mv.setViewName("/adminlogin");
		mv.addObject("code", code);
		
		return mv;
	}
	
	@PostMapping("/adminLogin")
	public ModelAndView adminLogin(Admin admin, String code, 
			                         HttpSession session, ModelAndView mv) {
		
		Object o = session.getAttribute("code"); //从Session中取出数据
		if(null != o) {
			String s = (String) o;
			if(o.equals(code)) {
				// 进行登录校验
				Admin a = this.adminService.login(admin);
				if(null == a) {
					mv.setViewName("forword:/adminlogin");
					mv.addObject("msg", "密码或或密码不正确。");
					String ncode = (int)(Math.random()*10000)+"";
					
				    session.setAttribute("code", ncode); // 在session中存储数据（服务器端对象）
					
					
					mv.addObject("code", ncode);
				}else {
					mv.setViewName("redirect:/tempage/manage");
					session.setAttribute("userInfo", a);
				}
				
			}else {
				mv.addObject("msg", "验证码不正确");
				mv.setViewName("/adminlogin");
				String ncode = (int)(Math.random()*10000)+"";
				
			    session.setAttribute("code", ncode); // 在session中存储数据（服务器端对象）
				
				
				mv.addObject("code", ncode);
			}
		}
		
		return mv;
	}
	
	
	@RequestMapping("/tempage/{pageName}")
	public String pagePath(@PathVariable("pageName") String pageName) {

		return pageName;
	}

}
