package com.thzhima.charsequence;

public class StringDemo1 {

	public static void main(String[] args) {
		
		String str = "hello"; // ���������ķ������ĳ������д���"hello"�ַ������󡣡�
		String str3 = "hello"; // ֻҪ�ַ�����ֵ����ͬ�ģ��ʹӳ�������ȡͬһ�����󸳸�������
		String str4 = "world";  // ֻҪ��������û��ָ����ֵ�����½�һ���洢�ڳ������С�
		
		System.out.println(str == str4);
		
		System.out.println(str == str3);
		
		System.out.println("str == 'hello': " + (str == "hello"));
		
		
		// new�ͻᴴ��һ���¶��󣬲�ʹ��ָ�������ʼ����new�Ĺ����У��������¶�������������
		String str2 = new String("hello"); 
		System.out.println("str2 == str : "+ (str2 == str));
		
		String str5 = new String("hello");
		System.out.println("str2 == str5 : "+ (str2 == str5));

		String str6 = new String("hi"); // "hi"�ڳ����أ�str6���õĶ����ڶ��ϡ�
		
		
		
	}
}
