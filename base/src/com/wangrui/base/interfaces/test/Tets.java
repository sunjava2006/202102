package com.wangrui.base.interfaces.test;

public class Tets {

	public static void main(String[] args) {
		Loadable l = new Ship();
		
		System.out.println(l.maxLoad);
		l.load();
		
		// 运行时多态
	}

}
