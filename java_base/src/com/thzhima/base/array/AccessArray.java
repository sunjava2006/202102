package com.thzhima.base.array;

public class AccessArray {

	public static void main(String[] args) {
		String[] a = new String[3];
		
		a[0] = "I";
		a[1] = "like";
		a[2] = "java";
//		a[3] = "."; ������������ķ�Χ��������ʱ�쳣��
		
		System.out.println(a[0]);
		
		System.out.println("����ĳ����ǣ�" + a.length);
		
		for(int i=0; i<a.length; i++) {
			a[i] = a[i] + "!";
			System.out.println(i + ": "+ a[i]);
		}
		
		for(String s : a) {
			System.out.println(" : " + s);
		}
				
	}
}
