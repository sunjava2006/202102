package com.wangrui.javaadvance.thread;

public class StopThread {

	public static void main(String[] args) throws InterruptedException {
		
		Runnable r = new Runnable() {

			
			@Override
			public void run() {
			   for(;;) {
				   System.out.println("-----**-----");
				   Thread currThread = Thread.currentThread();
				   
				   boolean interrupted = currThread.isInterrupted();
				  
				   // boolean interrupted = Thread.interrupted(); // 判断当前线程是否被打断
				  // System.out.println("2::interrupted():"+Thread.interrupted());
				   
				   if(interrupted) {
					   
					   System.out.println("2:::::::::::"+currThread.isInterrupted());
					   break;
				   }
				   
			   }
			}
			
		};
		
		Thread t = new Thread(r);
		t.start();
		
		t.join(500);
		
		
		t.interrupt(); // 打断线程t
		
//		t.suspend();
//		t.resume();
//		t.stop();
//		
	}
}
