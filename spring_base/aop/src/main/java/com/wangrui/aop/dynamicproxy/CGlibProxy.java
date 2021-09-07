package com.wangrui.aop.dynamicproxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGlibProxy implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		
		Log log = new Log();
		log.log();
		
		proxy.invokeSuper(obj, args);
		
		return null;
	}
	
	public static void main(String[] args) {
		CGlibProxy proxy = new CGlibProxy();
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(PrintService.class);
		enhancer.setInterfaces(PrintService.class.getInterfaces());
		enhancer.setCallback(proxy);
		
		Service ps = (Service) enhancer.create();
		
		ps.service("地图");
	}

}
