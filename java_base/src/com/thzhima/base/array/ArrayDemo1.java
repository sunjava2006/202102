package com.thzhima.base.array;

import java.util.Arrays;

public class ArrayDemo1 {
    int[] a; // a = null;��ȱʡ��ʼ���������ʼ��Ϊnull��
    
    {
    	System.out.println(a);
    }
    
	public static void main(String[] args) {
		// ����һ������
		int[] a = null;  // �Ƽ��ķ�ʽ 
		int b[];  // c������һ���ġ��ֲ�����������ȱʡ��ʼ����������ʽ���г�ʼ����
		System.out.println(a);
		
		b = new int[3]; // ����һ������Ϊ3��int��������
		boolean[] barr = new boolean[3]; // ����������һ�� boolean���͵�������󣬳���Ϊ3��
		Object[] objArr = new Object[4]; // ����������һ��Object���͵�������󣬳���Ϊ4��
		
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(barr));
		System.out.println(Arrays.toString(objArr));
		
		b[0] = 10;
		b[1] = 20;
		b[2] = 30;
		System.out.println(Arrays.toString(b));
		barr[0] = true;
		barr[2] = true;
		System.out.println(Arrays.toString(barr));
		objArr[0] = "hello";
		objArr[1] = new Object();
		objArr[2] = b;
		System.out.println(Arrays.toString(objArr));
	}
}
