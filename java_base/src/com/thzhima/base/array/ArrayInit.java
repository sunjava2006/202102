package com.thzhima.base.array;

public class ArrayInit {

	public static void main(String[] args) {
		int[] a = new int[3];  // [0, 0, 0]
		int[] b = new int[] {10, 20, 30}; // [10, 20, 30] ����Ϊ��ʼֵȷ���ĳ��ȡ�
		int[] c = {100, 200, 300, 400}; // ��̬��ʼ��
		
		int[] d ;
//		d = {1, 2, 3};
		// ֻҪ�г�ʼֵ����ֻ�ܰ���ʼֵ�������������[����]����ָ����
		d = new int[] {100, 200, 300}; 
	}
}
