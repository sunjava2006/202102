package com.wangrui.base.array.test;

import java.util.Arrays;

public class Fibo {

	public static void main(String[] args) {
		
		
		int[] a = new int[10];
		a[0] = 1;
		a[1] = 1;
		
		for(int i = 2; i < a.length; i++) {
			a[i] = a[i-1] + a[i-2];
		}
		System.out.println("a:" + Arrays.toString(a));
		
		// ����ĸ���
		// clone
		int[] b = a.clone();  // �ǶԵ�ǰ�����ǳ�ȸ��ơ�
		System.out.println("b:" + Arrays.toString(b));
		System.out.println("a==b: " + (a == b)); // ����֮��==�Ƚϣ��Ƚϵ��ǵ�ַ��
		
		int[] c = a;
		System.out.println("c:"+Arrays.toString(c));
		System.out.println("a==c:" + (a==c));
		// Arrays
		// System
		
		
	}
}
