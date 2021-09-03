package com.wangrui.newfature.lambda;

import java.util.Comparator;

public class Demo1 {

	public static void main(String[] args) {
		
		// =========================使用Lambda表达式===========================
		// 实际上是一个匿名类，创建了一个匿名类的对象
		Runnable target = ()->{System.out.println(Thread.currentThread().getName());};
		
		// 从形式上来看： 以函数为参数。
		Thread t = new Thread(target);
		
		t.start();
		
		//=========================不使用Lambda===========================
		Runnable target1 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				
			}
		};
		
		Thread t1 = new Thread(target1);
		t1.start();
		
		
		
		//======================== 什么样的类型可以用lambda? ===============================
		
		Flyable fly = s->{System.out.println("-----------------"+s);};
		
		fly.fly("8");
		
		//===========================有参有返回===================
		MyCompare compare = (int i, int j)->i-j;
		
		
		int result = compare.compare(2, 5);
		System.out.println(result);
		
		
		//==================== 引用实例方法 ========================
		Thread t2 = new Thread() {
			public void run() {
				System.out.println(">>>>>>>>>>>>>>>>>>>>"+Thread.currentThread().getName());
			}
		};
		
		Human h = new Human();
		
		
		Runnable r = h::sleep; // 引用实例方法
		
		Thread t3 = new Thread(r, "t3");
		t3.start();
		
		//================ 引用静态方法   ==========================
		Comparator<Integer> comparator = Integer::compare;
		
		
		// ================== 引用类的实例方法 ===============================
		ClassRoom rr = Human::walk;
		rr.todo(h);
		
		//=================== 构造引用 =======================
		Party p = Human::new;
		
		Human hh = p.getHuman();
		
		hh.walk();
		hh.sleep();
	}
}
