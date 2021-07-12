package com.wangrui.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceProxy {

	public static void main(String[] args) {
		
		final ReportService report = new ReportService();
		
		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Validate validate = new Validate();
				if (validate.isOk()){
					report.service();
					
				}
				return null;
			}
		};
		
		Object o = Proxy.newProxyInstance(Service.class.getClassLoader(), report.getClass().getInterfaces(), h);
		
		// 在不改变接口定义的情况下，加入了附加的功能（逻辑）。
		Service service = (Service) o;
		service.service();
	}
	
	
	
}
