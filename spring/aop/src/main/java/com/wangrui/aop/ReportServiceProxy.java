package com.wangrui.aop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ReportServiceProxy {
	
	public static void main(String[] args) {
		
		
		MethodInterceptor interceptor = new MethodInterceptor() {
			
			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				PrintService report = new PrintService();
				Validate validate = new Validate();
				if(validate.isOk()) {
					report.service();
				}
				
				return null;
			}
		};
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(PrintService.class);
		enhancer.setCallback(interceptor);
		
		
		PrintService rs = (PrintService) enhancer.create();
		System.out.println(rs.getClass().getName());
		
		rs.service();
	}

}
