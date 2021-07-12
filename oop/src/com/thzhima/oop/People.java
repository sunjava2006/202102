package com.thzhima.oop;

public class People {

	String name = "xxx";
	int age;
	boolean married;
	
	{
		age = 2;
		System.out.println("-----------------");
	}
	
	People(){
		age = 1;
	}
	
	People(String name){
		this(name, 1, false); // 对当前类构造的引用
	}
	
	People(String name, int age, boolean married){
		this.name = name;
		this.age= age;
		this.married = married;
	}
	
	void a() {
		
	}
	
	void b() {
		this.a();
	}
	
	void work() {
		System.out.println(this.name + "工作中");
	}
	
	void work(String task) {
		System.out.println(this.name + "完成"+task+"中");
	}
	
//	String work(String target) { // 参数列表相同，编译不通过。
//		System.out.println(this.name + "完成"+target+"中");
//		return "";
//	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		/* 1）new 创建对象，按类定义，分配内存空间，并缺省初始化属性。
		 * 2）代码块中的内容，会在对象创建之后执行。
		 * 3）执行构造
		 * 
		 * new 一个对象。完成两件事：
		 *    一是创建对象（缺省初始化）。
		 *    二是初始化对象， 可以用申明属性给定默认值、在代码块、在构造中初始化对象的属性。
		 */
		People p = new People("wang", 20, false);
		
		p.work();
		p.work("学习Java");
		
		String name = p.name;
		int age = p.age;
		
		System.out.println(name);
		System.out.println(age);
		
		p.married = true;
		System.out.println(p.married);
	}
	
}
