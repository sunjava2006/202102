package com.wangrui.javaadvance.thread;

public class Bank {

	static final Object o  = new Object();
	
	// 同步方法。在同一时刻，在该对象上只能有一个同步方法执行。
	public  void save(Account a, int m) {
		synchronized (o) {
			System.out.println("--------------------");
			int r = a.money + m;
			System.out.println(Thread.currentThread().getName() + ":" + r);
			a.money = r;
			System.out.println("--------------------");
		}
		
	}

	public  void get(Account a, int m) {
		synchronized(o) {
			System.out.println("=====================");
			if (a.money >= m) {
				int r = a.money - m;
				System.out.println(Thread.currentThread().getName() + "get:" + r);
				a.money = r;
			}
			System.out.println("=====================");
		}
		
	}

	public static void main(String[] args) throws InterruptedException {

		Bank bank = new Bank();
		Bank bank2 = new Bank();
		Account a = new Account("123456", 100);
		Account a2 = new Account("123456", 100);

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				bank.save(a, 100);
			}
		};

		Runnable runnable2 = new Runnable() {

			@Override
			public void run() {
				bank2.get(a2, 100);

			}
		};

		Thread t = new Thread(runnable);
		Thread t2 = new Thread(runnable2);

		t.start();
		t2.start();

		t.join();
		t2.join();

		System.out.println(a.money);

	}
}
