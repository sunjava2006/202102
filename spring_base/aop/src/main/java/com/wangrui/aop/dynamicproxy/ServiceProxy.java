package com.wangrui.aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ServiceProxy {

	public static void main(String[] args) {
		
		
		
		
		Service s = (Service) Proxy.newProxyInstance(Service.class.getClassLoader(), PrintService.class.getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("----------------------");
//				System.out.println(proxy);
				System.out.println(method.getName());
				System.out.println(Arrays.toString(args));
				PrintService ps = new PrintService();
				ps.service((String)args[0]);
				
				Log log = new Log();
				log.log();
				
				return null;
			}
		});
		System.out.println(s instanceof Service);
		
		System.out.println(s.getClass().getName());
		System.out.println(Arrays.toString(s.getClass().getInterfaces()));
		s.service("图纸");
	}
	
}
