package com.wangrui.base.abs;

public abstract class EngineX {

	public void addOil() {
		System.out.println("加油");
	}
	
	// 抽象方法（只有访问的申明，没有方法体）
	public abstract void run();
	
	
	public abstract void fire();
}
