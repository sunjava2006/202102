package com.wangrui.ioc;

public class Boy {

	private GirlFriend gf;

	public Boy() {

	}

	public Boy(GirlFriend gf) {
		this.gf = gf;
	}

	public GirlFriend getGf() {
		return gf;
	}

	public void setGf(GirlFriend gf) {
		this.gf = gf;
	}

	public void marry() {
		System.out.println("与" + gf.getName() + "结婚.");
	}

	public static void main(String[] args) {
		Boy boy = new Boy();
		boy.setGf(Mother.seesee());
		boy.marry();

	}
}
