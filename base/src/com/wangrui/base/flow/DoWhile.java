package com.wangrui.base.flow;

public class DoWhile {

	public static void main(String[] args) {
		
		
		// 1、循环条件的初始化
		int i = 1;
		
		
		do {
			// 2、循环条件的改变
			i++;
			
			System.out.print("*");
			
		}while(i<=10);  // 3、进入循环的条件
		
		System.out.println();
		//=========================================
		
		while(i<=20) {// 3、进入循环的条件
			i++;// 2、循环条件的改变
			System.out.print("#");
		}
		
		//====================================
		
		for ( ; ; ) {
			
		}
		
	}
}
