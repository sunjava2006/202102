package com.thzhima.charsequence;

public class StringBufferDemo {
	
	public static void main(String[] args) {
		
//		StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		
		sb.append("I like Java. ");
		System.out.println(sb);
		
		sb.append("I like Python.");
		System.out.println(sb.toString());
		
		sb.insert(1, "*");
		System.out.println(sb);
		
		sb.delete(1, 2);
		System.out.println(sb);
		
		sb.replace(0, 10, "_");
		System.out.println(sb);
		
		System.out.println(sb.indexOf("like"));
		
		System.out.println(sb.capacity());
		System.out.println(sb.length());
		
		System.out.println(sb.charAt(0));
		
		sb.trimToSize();
		System.out.println(sb.capacity());
		System.out.println(sb.length());
	}
}
