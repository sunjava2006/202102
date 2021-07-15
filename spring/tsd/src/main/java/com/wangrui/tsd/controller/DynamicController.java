package com.wangrui.tsd.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wangrui.tsd.bean.Dynamic;
import com.wangrui.tsd.service.DynamicService;

@Controller
public class DynamicController {
	
//	@Value("${upload_dir}")
//	private String uploadPath;

	@Autowired
	private DynamicService dynamicService;
	
	@RequestMapping("/publishDynamic")
	@ResponseBody
	public Map publish(MultipartFile pic, Dynamic dynamic) {
		System.out.println(dynamic);
		String uploadPath = Thread.currentThread().getContextClassLoader().getResource("static").getPath()+"/pictures";
		File dir = new File(uploadPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		Map map = new HashMap();
		String fileName = pic.getOriginalFilename();
	    try {
			pic.transferTo(new File(uploadPath, fileName));
			dynamic.setPicture(fileName);
			this.dynamicService.publish(dynamic);
			
			map.put("msg", "ok");
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			map.put("msg", "nook");
		}
		return map;
	}
}
