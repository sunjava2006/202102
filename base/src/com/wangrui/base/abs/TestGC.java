package com.wangrui.base.abs;

public final class TestGC {

	@Override
	public void finalize() {
		System.out.println("finalize");
	}
	
	public static void main(String[] args) {
		TestGC t = new TestGC();
		
		t = null;
		System.gc();
		System.out.println("--------------------");
		
//		TestGC tt = new TestGC() {};
//		
//		class T extends TestGC{
	
//		}
		
		
		final int i = 90;
//		i = 99;
	}
}
