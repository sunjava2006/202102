package com.thzhima.oop;

public class Cat {

	static String kind ;  // ��̬����
	String name;   // ʵ������
	
	static void test() {
		System.out.println(new Cat().name);
		System.out.println(kind);
		System.out.println("test---------");
	}
	
	static {  // ��̬�����
		kind = "��˹";
//		System.out.println(name);
		System.out.println("=================");
	}
	
	{  // ʵ�������
		kind = "��˹";
		System.out.println("--------------------");
	}
	
	public static void main(String[] args) {
//		@SuppressWarnings("unused")
		Cat cat = new Cat();
//		
		Cat cat2 = new Cat();
		
		System.out.println(Cat.kind);
		Cat.kind = "����";
		System.out.println(Cat.kind);
		System.out.println(cat2.kind);
		System.out.println(cat.kind);
		
		Cat.test();
		Cat.test();
	}
	
	
}
