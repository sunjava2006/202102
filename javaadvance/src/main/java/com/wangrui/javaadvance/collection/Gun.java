package com.wangrui.javaadvance.collection;

import java.util.Stack;

public class Gun {

	Stack<Bullet> bs = new Stack<>();
	
	public void push(Bullet b) {
		this.bs.push(b);
	}
	
	public void fire() {
		if(!bs.empty()) {
			Bullet b = bs.pop();
			b.fire();
		}
	}
	
	public boolean have() {
		return !this.bs.empty();
	}
	
	public static void main(String[] args) {
		Gun gun = new Gun();
		
		for(int i=1;i<=5;i++) {
			gun.push(new Bullet());
		}
		
		while(gun.have()) {
			gun.fire();
		}
		
	}
	
}
