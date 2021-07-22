package com.wangrui.tsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangrui.tsd.bean.Admin;
import com.wangrui.tsd.dao.AdminDao;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	
	public Admin login(Admin admin) {
		this.adminDao.find(admin);
		return admin;
	}
}
