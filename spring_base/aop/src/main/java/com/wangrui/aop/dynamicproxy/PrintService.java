package com.wangrui.aop.dynamicproxy;

import org.springframework.stereotype.Service;

//@Service
public class PrintService implements com.wangrui.aop.dynamicproxy.Service {

	@Override
	public void service(String task) {
		System.out.println("========   print   ========" + task);
	}

	@Override
	@Monitor
	public int service2() {
		return 100;
	}
	
	

}
