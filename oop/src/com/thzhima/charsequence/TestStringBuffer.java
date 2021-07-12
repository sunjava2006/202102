package com.thzhima.charsequence;

public class TestStringBuffer {

	public static void main(String[] args) {
		int count = 100000;
		
		String s = "";
		
		long start = System.currentTimeMillis();
//		for(int i=1;i<=count;i++) {
//			s += i;
//		}
		long end = System.currentTimeMillis();
		System.out.println("用时 ："+(end-start));
		
		
        StringBuilder sb = new StringBuilder();
		
		start = System.currentTimeMillis();
		for(int i=1;i<=count;i++) {
			sb.append(i);
		}
		end = System.currentTimeMillis();
		System.out.println("用时 ："+(end-start));
		
	}
}
