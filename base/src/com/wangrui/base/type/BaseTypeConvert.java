package com.wangrui.base.type;

public class BaseTypeConvert {
	
	static short s ; // ���ж���ı�����ȱʡ��ʼ������ֵ���Ͷ�Ϊ0��booleanΪfalse������Ϊnull��
	
	static String str;

	public static void main(String[] args) {
		int a = -129;
		byte b = (byte) a;
		System.out.println(b);
		
		float f = 20000999999999999L;
		System.out.println(f);
		
		
	    long l = 0;
	    System.out.println(l);
	    
	    
	    System.out.println(s);
	    
	    System.out.println(str);
	    
	    String s ; // �����ж���ı����ƣ��ֲ��������ֲ���������ȱʡ��ʼ���������ֶ���ʼ����
//	    System.out.println(s);
	}
}
