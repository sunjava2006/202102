package com.wangrui.base.accessable;

public class Father {

	public String gender;
	
	protected int monery;
	
	// Ĭ��
	String nickName;
	
	private Brush myBrush;
	
	public void about() {
		System.out.println(nickName + ", " +gender + ", " + monery + ", " + myBrush );
	}
	
}
