package com.thzhima.charsequence;

public class String2 {

	public static void main(String[] args) {
		String str = "i like Java.";
		
		char k = str.charAt(4); // ȡ��ָ���������ַ�
		System.out.println(k);
		
	    int code = str.codePointAt(8); // ȡ��ָ�������ַ��ı���ֵ��
	    System.out.println(code);
	    
	    int jat = str.indexOf('j', 8); // ��ǰ�Ⱥ����ָ�����ַ�����������λ�õ��������Ҳ�������-1��
	    System.out.println(jat);
	    
	    System.out.println(str.lastIndexOf("jv"));
	    
	    System.out.println(str.concat(" i like python too.")); // ����һ���µ�String�����������ַ�����ƴ�ӡ�
	    
	    System.out.println(str.substring(4, str.length()));
	    
	    System.out.println(str.toUpperCase());
	    
	    System.out.println(str);
	    
	    System.out.println(str.toLowerCase());
	    
	    System.out.println(str.contains("Java"));
	    System.out.println(str.startsWith("I like", 1));
	    System.out.println(str.endsWith("."));
	    
	    System.out.println("str.equals(\"I like Java.\") : " +(str.equals("I like Java.")));
	    
	    System.out.println("str.contentEquals(\"I like Java.\"): "+ (str.contentEquals("I like Java.")));
	    
	    System.out.println("���Դ�Сд�ıȽϣ�"+ (str.equalsIgnoreCase("i like JAVA.")));
	    
	    System.out.println(str.replaceAll("\\b", "*"));
	    System.out.println(str.replaceFirst("\\b", "*"));
	    System.out.println(str.replace("i", "I"));
	}
}
