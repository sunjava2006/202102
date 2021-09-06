package com.wangrui.ioc;

public class GirlFriend {

	private String name;
	
	public GirlFriend(String name) {
		this.name = name;
	}

	public GirlFriend() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GirlFriend [name=" + name + "]";
	}
	
	
	
}
