package com.thzhima.base.work;

public class 吃桃子 {

	public static void main(String[] args) {
		/**
		 * 猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个，
		 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上
		 * 都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下
		 * 一个桃子了。求第一天共摘了多少。（知识点：循环语句 while）
		 * 
		 * 10  9  8   7
		 * 1   4  10  22
		 * 
		 *    (10-5)-1=4
		 *    (4-2)-1=1
		 *    
		 *    (n+1)*2
		 * 
		 * 
		 */
		
		int n = 1;
		for(int i=1;i<=9;i++) {
			n = (n+1)*2;
		}
		System.out.println(n);
		System.out.println("============================");
		for(int i=1; i<=9; i++) {
			System.out.println(n);
			n = n/2-1;
		}
		System.out.println(n);
	}
}
