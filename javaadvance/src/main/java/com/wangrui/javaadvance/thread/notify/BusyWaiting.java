package com.wangrui.javaadvance.thread.notify;

public class BusyWaiting {

	public static void main(String[] args) {
		int computer = 0;
		
		while(true) { // 繁忙等待 --》自旋锁
			if(computer>0) {
				System.out.println("买");
			}
		}
		
	}
	
}
