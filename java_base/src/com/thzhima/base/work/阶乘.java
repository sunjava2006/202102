package com.thzhima.base.work;

import java.util.Arrays;

public class 阶乘 {

	public static void main(String[] args) {
		/*
		 * 求20的阶乘: 1*2*3*4*...20
		 */
		
		long result = 1;
		
		for(int a=2; a<=20; a++) {
			result *= a;
		}
		
		System.out.println(result);
		
		
		/*
		 * 这个数列是由13世纪意大利斐波那契提出的,故叫斐波那契数列
                      1、1、2、3、5、8、13、21….数列，问将这个数列中所有数相加
                      大于等于5000,数列中最后一个数是多少？
		 */
		long sum = 0;
		int a = 0;
		int b = 1;
		do {
			int c = a+b;
			a = b;
			b = c;
//			System.out.println(a);
			sum = sum + a;
			
		}while(sum<5000);
		System.out.println("sum小于5000，数列中最后一个值是：" + a);
	
		/**
		 * 输出斐波那契数列20个以内的值。
		 */
		int[] array = new int[20];
		array[0] = 1;
		array[1] = 1;
		
		for(int i=0; i<array.length-2; i++) {
			array[i+2] = array[i]+array[i+1];
		}
		System.out.println(array);
		System.out.println(Arrays.toString(array));
		
		/**
		 * 求10000以内的素数
		 */
		for(int i=2 ; i<10000; i++) {
			for(int j=2; j<=i; j++) {
				if(0 == i%j ) {
					if(i!=j) {
						break;// 除数不 为被除数的情况下，被整除。就不是一个素数。取下一个数。
					}else {
						System.out.println("素数： "+ i);
					}
				}
			}
		}
		
		/**
		 * 求水仙花数
		 */
		for(int i=100; i<1000; i++) {
			int h = i/100;
			int m = i%100/10;
			int l = i%10;
			
			if(h*h*h + m*m*m + l*l*l == i) {
				System.out.println("水仙花数 : " + i);
			}
		}
		
		/**
		 * 今有物不知其数，三三数之剩二，五五数之剩三，七七数之剩二，问物几何？
		 */
		int w = 3*7*5;
		
		while(true) {
			if(2==w%3 && 3==w%5 && 2==w%7) {
				break;
			}
			w++;
		}
		
		System.out.println("数为：" + w);
		
	}
}
