package com.wangrui.base.array;

import java.util.Arrays;

public class ArrayDeclare {

	public static void main(String[] args) {
		
		int a[] = new int[3]; // ����һ������Ϊ3���������顣
		//        [0, 0, 0]
		
		boolean[] b = new boolean[3];
		//            [false, false, false]
		
		String[] s = new String[3];
		//           [null, null, null]
		
		System.out.println(a);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(s));
		
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;
		System.out.println(Arrays.toString(a));
		
		//================================================
		int[] c = {100, 200, 300};  // ��̬��ʼ��,����������һͬʹ�á�
		System.out.println(Arrays.toString(c));
		
		int[] d = new int[] {1000, 2000, 3000}; // �г�ʼ�����ݣ��Ͳ���ָ�����鳤�ȡ�����ĳ��Ⱦ��ǳ�ʼ���ݵĴ�С��
		System.out.println(Arrays.toString(d));
		
		
		int[] e;
		e = new int[]{};
	}
}
