package com.wangrui.base.flow;

public class DoWhile {

	public static void main(String[] args) {
		
		
		// 1��ѭ�������ĳ�ʼ��
		int i = 1;
		
		
		do {
			// 2��ѭ�������ĸı�
			i++;
			
			System.out.print("*");
			
		}while(i<=10);  // 3������ѭ��������
		
		System.out.println();
		//=========================================
		
		while(i<=20) {// 3������ѭ��������
			i++;// 2��ѭ�������ĸı�
			System.out.print("#");
		}
		
		//====================================
		
		for ( ; ; ) {
			
		}
		
	}
}
