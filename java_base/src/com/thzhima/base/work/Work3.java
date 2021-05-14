package com.thzhima.base.work;

public class Work3 {

	public static void main(String[] args) {
		
		/*
		 * 1、1、2、3、5、8、13、21
		 */
	
		int count = 1;
		int a = 0;
		int b = 1;
		do {
			int c = a+b;
			a = b;
			b = c;
			System.out.println(a);
			count++;
		}while(count<=20);
		
		
		int i = 1;
		do {
			int j = 1;
			do {
				System.out.print(j + "*" + i + "=" + j*i + "\t");
				j++;
			}while(j<=i);
			
			System.out.println();
			i++;
		}while(i<=9);
	}
}
