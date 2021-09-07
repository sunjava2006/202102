package com.wangrui.aop.dynamicproxy;



public class PrintService implements Service {

	@Override
	public void service(String task) {
		System.out.println("========   print   ========" + task);
	}

}
