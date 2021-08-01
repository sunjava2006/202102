package com.wangrui.base.flow;

public class For {

	public static void main(String[] args) {
		
		// for 是集约化的 while，将循环控制的三个要素，统一编写。
		
//		int i=1;//1
		
		// initial初始段 ;  condition条件 ;  post最后  
		for(int i=1 ;i<=10; i++) {//3
			System.out.print("*");
//			i++; //2
		}
		
	}
}
