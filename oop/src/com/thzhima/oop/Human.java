package com.thzhima.oop;

public class Human {

	/*
	  *  属性：就是在类中定义的变量。
	  * 成员变量：就是属性。就是在类中定义的“非静态”变量。 
	 */
	String gender;
	String birthDate;
	String name;
	String address;
	int age;
	boolean isMarried; 
	
	{ //  代码块
		System.out.println("=======================");
	}
	/**
	 * 构造方法。没有返回类型，方法名与类名相同。在new时被调用。
	 * 只有当任何一个构造都不申明的情况下，系统才会为我们创建无参的默认构造。
	 * 这个构造，什么也不作。
	 */
	Human(){   // 
		System.out.println("---------------------");
	}
	
	/* 方法名相同，参数列表不同。称方法重载。编译器会根据参数不同来确定不同的方法。
	 这样同名不同参，就构成了多态。由于不同的方法根据不同的参数列表来确定，
	 由于这个方法是在编译时就能确定的。所以称编译时多态。是Java面向对象中的的一种。
	 */
	Human(String gender, String name, String birthDate, String address,
		  int age, boolean  isMarried ){
		this.gender = gender;
		this.name = name;
		this.address = address;
		this.age = age;
		this.isMarried = isMarried;
		this.birthDate = birthDate;
	}
	
	/*
	 * 方法：就是在类中定义的函数。
	 * 函数的定义：
	 *    申明返回数据类型    函数名（形参）{
	 *              方法体...；
	 *      ....
	 * }
	 * void 表示该方法没有返回值。如果返回整型，申明返加类型就是：int. 
	 */
	void work() { 
		System.out.println(name + "工作中...........");
	}
	
	int sum(int a, int b) {


		return a + b;
	}

	public static void main(String[] args) {
		
		// Human 是类型申明 , li是对象名。new 关键字，用来创建对象。
		Human li = new Human();  
		System.out.println(li.name);
		System.out.println(li.address);
		System.out.println(li.gender);
		System.out.println(li.birthDate);
		System.out.println(li.age);
		System.out.println(li.isMarried);
		
		li.name = "礼义廉";
		li.address = "长江区，体育路8号";
		li.gender = "男";
		li.birthDate = "1979-12-30";
		li.age = 42;
		li.isMarried = true;
		
		System.out.println(li.name);
		System.out.println(li.address);
		System.out.println(li.gender);
		System.out.println(li.birthDate);
		System.out.println(li.age);
		System.out.println(li.isMarried);
		
		li.work();
		int result = li.sum(10, 20);
		System.out.println(result);
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		
		Human h = new Human("男", "张水", "1990--4-4", "南京江北新区", 30, false);
		System.out.println(h.name);
		System.out.println(h.address);
		System.out.println(h.gender);
		System.out.println(h.birthDate);
		System.out.println(h.age);
		System.out.println(h.isMarried);
		
		
	}
	
	
	
	
}
