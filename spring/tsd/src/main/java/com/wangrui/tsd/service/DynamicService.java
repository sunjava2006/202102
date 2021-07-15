package com.wangrui.tsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.tsd.bean.Dynamic;
import com.wangrui.tsd.dao.DynamicDao;

@Service
public class DynamicService {

	@Autowired
	private DynamicDao dynamicDao;
	
	public void publish(Dynamic dyn) {
		this.dynamicDao.add(dyn);
	}
}
