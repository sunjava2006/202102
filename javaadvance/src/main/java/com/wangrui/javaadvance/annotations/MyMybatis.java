package com.wangrui.javaadvance.annotations;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyMybatis {

	public static void main(String[] args) throws Exception {
		Class userDaoClass = Class.forName("com.wangrui.javaadvance.annotations.UserDao");
		
		Mapper[] mapperAnnotation = (Mapper[]) userDaoClass.getAnnotationsByType(Mapper.class);
		System.out.println(mapperAnnotation.getClass().getName());
		
		
		Method findMethod = UserDao.class.getMethod("find", int.class);
		
		Select[] s = findMethod.getAnnotationsByType(Select.class);
		System.out.println(Arrays.toString(s));
		String v = s[0].value();
		System.out.println(v);
		
		
	}
}
