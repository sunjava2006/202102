package com.thzhima.base;

public class ArithmaticOp {

	public static void main(String[] args) {
		//    加号（+）
		//	     减号（-）
		//	     乘号（*）
		//	     除号（/）
		//	     取模（%）
		//	    自增运算符（++）
		//	    自减运算符（--）
		
		int a =  1 + 2;
		System.out.println(a);
		
		a = a - 1;
		System.out.println(a);
		
		a = a * 2; // "*" 号是乘法运算符
		System.out.println(a);
		
		a = a / 3; // "/" 是除法运算符。
		System.out.println(a);
		
		System.out.println(4 / 3F); // 整数除的结果是整数，小数除的结果是小数。
		
		int m = 3 % 2;   // "%"是求模运算，就是取除法的余数。
		System.out.println(m);
		
		int i = 1;
		i++;   // i=i+1
		++i;   // ++在前是前置型，++在后是后置型。
		
		int j = 1;
		int k = ++j; // j=j+1;j=>2    k=j;k=>2  前置型，先+1，再拿来用。
		System.out.println(j);
		System.out.println(k);
		
		k = j++; // k=j;k=>2      j=j+1;j=>3  后置型，先拿来用，后+1。
		System.out.println("k=" + k +", j=" + j);
		
		
		int h = 1;
		h = ++h; // h=>2
		h = h++; // 2; 
		System.out.println(h);
		
		
		
		

		
		
	}
}
