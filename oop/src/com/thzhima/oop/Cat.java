package com.thzhima.oop;

public class Cat {

	static String kind ;  // ¾²Ì¬ÊôĞÔ
	String name;   // ÊµÀıÊôĞÔ
	
	static void test() {
		System.out.println(new Cat().name);
		System.out.println(kind);
		System.out.println("test---------");
	}
	
	static {  // ¾²Ì¬´úÂë¿é
		kind = "²¨Ë¹";
//		System.out.println(name);
		System.out.println("=================");
	}
	
	{  // ÊµÀı´úÂë¿é
		kind = "²¨Ë¹";
		System.out.println("--------------------");
	}
	
	public static void main(String[] args) {
//		@SuppressWarnings("unused")
		Cat cat = new Cat();
//		
		Cat cat2 = new Cat();
		
		System.out.println(Cat.kind);
		Cat.kind = "²¨ºÚ";
		System.out.println(Cat.kind);
		System.out.println(cat2.kind);
		System.out.println(cat.kind);
		
		Cat.test();
		Cat.test();
	}
	
	
}
