package com.wangrui.iocaop.ioc;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class Todo implements MethodReplacer{

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("============= hello ==========");
		return null;
	}

}
