package com.wangrui.base.type;

public class BaseType {

	public static void main(String[] args) {
		byte a = 127;// 8λһ���ֽڣ��������з����� 127~-128;
		short s = -32768;
		int i = 999999; // ����������������int���͡�
		long l = 9999999999999999L; // L ���߱������������Long�͡�
		
		float f = 3.14f; // ��������С������double���͡�
		double d = 3.14; 
		
		boolean b = true;
		
//		boolean bb = 1; Java������boolean���͵�ֵ����true\false�������Ͷ�������ת��Ϊ boolean���͡�
		
		char c = 'a'; // �Ǵ洢�����ַ������� 32λ
		char c2 = 97;
		System.out.println(c);
		System.out.println(c2);
		
		
		
		String str = "hello"; // String�������ͣ����ǻ�����������
		
		//==============================================
		long l2 = i; // 32λ->l2 63λ ��С�������͡���ֵΪ�����������͡�ʱ�������ˡ���ʽ������������ת����
		d = f;     // ������֪����С�ڴ����е������ǿ��Էŵ�����ڴ����еġ�
		s = a;
		
		f = (float) d;   // ����ڴ����е����ݷŵ���С�ڴ����У���������֪���ܲ��ܷŵ��¡�ǿ������ת��������ģ��ǳ���Ա��֤�ģ���
		
		
		
	}
}
