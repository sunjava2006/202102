package com.wangrui.ioc.methodInjection;

import com.wangrui.ioc.GirlFriend;

public abstract class Father {

	public abstract GirlFriend see();
	
	public  void run(String path) {
		System.out.println("==========================");
	}
}
