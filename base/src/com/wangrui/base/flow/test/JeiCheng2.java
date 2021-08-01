package com.wangrui.base.flow.test;

public class JeiCheng2 {

	public static long jc(long i) {
		if(i>1) {
			return i*jc(i-1);
		}
		else {
			return 1;
		}
	}
	
	public static void main(String[] args) {
		long r = jc(4);
		System.out.println(r);
	}
	
}
