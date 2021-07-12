package com.thzhima.advance.util;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		
		for(int i=1; i<=10; i++) {
			s.push(i);
		}
		
		System.out.println(s);
		
		System.out.println(s.peek());
		System.out.println(s.peek());
		System.out.println(s.peek());
		
		while(!s.empty()) {
			Integer v = s.pop();
			System.out.println(v);
		}
	}
}
