package com.thzhima.advance.threads;

public class Bank {

	private static final Object clock = new Object();
	
	public  double get(Account account, double amount) throws InterruptedException {
		synchronized(account) {
			System.out.println("------------------");
			double v = 0;
			if(account.amount >= amount) {
				Thread.sleep(10);
				v = amount;
				account.amount -= amount;
			}
			System.out.println("==================");
			return v;
		}
		
	}
	
	public  void save(Account account, double amount) {
		synchronized (account){
			System.out.println("*****************");
			
			account.amount += amount;
			System.out.println("$$$$$$$$$$$$$$$$$");
		}
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Bank bank = new Bank();
		
		Account account = new Account(1233214567890L, 10000);
		Account account2 = new Account(1233214567891L, 10000);
		
		Runnable getTask = ()->{
			try {
				System.out.println(Thread.currentThread().getName()+ "»°µ√£∫"+ bank.get(account, 7000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable saveTask = ()->{
			bank.save(account, 8000);
			System.out.println(Thread.currentThread().getName()+ "¥Ê«Æ");
		};
		
		Thread t = new Thread(getTask);
		Thread t2 = new Thread(saveTask);
		
		Thread t3 = new Thread(()->{
			while(true) {
				System.out.println(t.getName() + " :" + t.getState());
				System.out.println(t2.getName() + " :" + t.getState());
			}
		});
		t3.setDaemon(true);
		//t3.start();
		
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		System.out.println(" £”‡£∫"+account.amount);
	}
}
