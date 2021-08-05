package com.wangrui.base.accessable;

public class Mother {

	public void aboutFather() {
		Father f = new Father();
		
		System.out.println(f.nickName +", " + f.gender + ", " + f.monery + "," );
	}
}
