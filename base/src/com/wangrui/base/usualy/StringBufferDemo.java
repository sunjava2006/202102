package com.wangrui.base.usualy;

public class StringBufferDemo {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Hello World");
//		StringBuilder sb = new StringBuilder("Hello World");
		
		sb.replace(0, 3, "*");
		System.out.println(sb);
		
		sb.delete(0, 1);
		System.out.println(sb);
		
		sb.append("!");
		System.out.println(sb);
		
		sb.insert(1, " ");
		System.out.println(sb);
		
		int at = sb.indexOf("Wo2");
		System.out.println(at);
		
		
		
		
		System.out.println("=================================");
		
		int count = 100000;
		String s = "";
		long start = System.currentTimeMillis();
		for(int i=0 ;i<count; i++) {
			s += i;
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		System.out.println("-----------------------------------");
		
		start = System.currentTimeMillis();
		for(int i=0 ;i<count; i++) {
			sb.append(i);
		}
		end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
