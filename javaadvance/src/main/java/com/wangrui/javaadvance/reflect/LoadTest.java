package com.wangrui.javaadvance.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.wangrui.javaadvance.jdbc.A;

public class LoadTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class aclass = Class.forName("com.wangrui.javaadvance.jdbc.A");
		
		A a = (A) aclass.newInstance();
		System.out.println(a);
		
		Constructor aconstructor = aclass.getConstructor(int.class );
		A a2 = (A) aconstructor.newInstance(200);
		System.out.println(a2);
		
		
		// 操作属性
		Field[] afields = aclass.getDeclaredFields(); // getFields()
		for(Field f : afields) {
			System.out.println(f.getName());
		}
		
		Field valueField = aclass.getDeclaredField("value");
		valueField.setAccessible(true);//  设置字段可访问为true
		
		valueField.set(a, 88);
		System.out.println(a);
		
		// 操作方法
		Method[] methods = aclass.getDeclaredMethods();
		for(Method m : methods) {
			System.out.println(m.getName());
		}
		
		Method workMethod = aclass.getDeclaredMethod("work", String.class);
		
		workMethod.invoke(a, "打印"); // 调用方法
		
	}

}
