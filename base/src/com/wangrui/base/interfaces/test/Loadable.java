package com.wangrui.base.interfaces.test;

public interface Loadable {

	int maxLoad  = 10;
	
	void load();
	
	default void a(){
		
	}
}
