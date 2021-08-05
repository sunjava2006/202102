package com.wangrui.base.abs;

public class Test {

	public static void main(String[] args) {
		EngineX engine = new AskSky2() ;
		
		engine.addOil();
		
		engine.fire();
		
		engine.run();
		
		
		EngineX ex = new EngineX() {
			
			@Override
			public void run() {
				System.out.println("---run-----");
			}
			
			@Override
			public void fire() {
				System.out.println("----fire-----");
			}
		};
		
		ex.addOil();
		ex.fire();
		ex.run();
		
		System.out.println(ex.getClass().getName());
		Object o;
	}
}
