package com.thzhima.oop;

public class FinalizeTest {

	@Override
	public void finalize() {
		System.out.println("call finalice()");
	}
	
	public static void main(String[] args) {
		FinalizeTest ft = new FinalizeTest();
		ft = null;
		
		new FinalizeTest();
		
		FinalizeTest[] ftarr = new FinalizeTest[3];
		ftarr[0] = new FinalizeTest();
		ftarr[0] = null;
		ftarr = null;
		
		System.gc();
	}
}
