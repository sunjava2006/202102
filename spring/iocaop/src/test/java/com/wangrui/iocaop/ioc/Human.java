package com.wangrui.iocaop.ioc;

public abstract class Human {

	public abstract Ball makeBall();
	
	public abstract void todo();
	
	public void play() {
		Ball ball = this.makeBall();
		System.out.println("play" + ball);
	}
}
