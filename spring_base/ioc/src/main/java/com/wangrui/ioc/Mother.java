package com.wangrui.ioc;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.beans.factory.support.MethodReplacer;

import com.wangrui.ioc.methodInjection.Father;

public class Mother implements MethodReplacer{

	public static GirlFriend seesee() {
		return new GirlFriend("小胖");
	}

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
//		System.out.println(obj.getClass().getSuperclass().getName());
//		System.out.println(method.getName());
	    if(Father.class.getName().equals(obj.getClass().getSuperclass().getName())) {
	    	Father f = (Father) obj;
	    	System.out.println(f + "跑" + Arrays.toString(args));
	    }
		
		
		return null;
	}
}
