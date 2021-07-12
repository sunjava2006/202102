package com.thzhima.advance.threads;

public class Procuder {

	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
		
	    Object[] list = {1};
		
		Thread t = new Thread(()->{
			try {
				synchronized (o) {
					System.out.println(Thread.currentThread().getName()+"wait");
					o.wait();    // 必须先获得锁。wait时锁是释放的。
//					Thread.sleep(10000); // 锁不释放的。与线程之前是否获取锁没有关系。所以也不改变锁定的状态。
				    if(list[0]!=null) {
				    	list[0]= null;
				    	System.out.println("买到了");
				    }else {
				    	System.out.println("没买到");
				    }
						
					System.out.println("end");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	
		t.start();
		
		Thread t2 = new Thread(()->{
			try {
				synchronized (o) {
					System.out.println(Thread.currentThread().getName()+"wait");
					o.wait();    // 必须先获得锁。wait时锁是释放的。

				    if(list[0]!=null) {
				    	list[0]= null;
				    	System.out.println("买到了");
				    }else {
				    	System.out.println("没买到");
				    }
						
					System.out.println("end");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t2.start();
		
		
		Thread.sleep(3000);
		synchronized (o) {
			System.out.println("will notify");
			o.notify();
		}
		
	}
}
