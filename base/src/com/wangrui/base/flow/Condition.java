package com.wangrui.base.flow;

public class Condition {

	public static void main(String[] args) {

		int score = (int) (Math.round(Math.random() * 100));
		char grad = 0;

		if (score >= 90) {
			grad = '��';
		} else if (score >= 80) {
			grad = '��';
		} else if (score >= 70) {
			grad = '��';
		} else {
			grad = '��';
		}

		System.out.println(score + ":" + grad);

	}
}
