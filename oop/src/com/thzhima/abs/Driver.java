package com.thzhima.abs;

public abstract class Driver {

	public abstract void change(); // ³éÏó·½·¨
	
	public void run() {
		System.out.println("run............");
	}
	
	public static void main(String[] args) {
		Driver d = new Driver20();
		
		d.change();
		d.run();
	}
}
