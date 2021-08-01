package com.wangrui.base.flow;

public class Condition {

	public static void main(String[] args) {

		int score = (int) (Math.round(Math.random() * 100));
		char grad = 0;

		if (score >= 90) {
			grad = 'ÓÅ';
		} else if (score >= 80) {
			grad = 'Á¼';
		} else if (score >= 70) {
			grad = 'ÖÐ';
		} else {
			grad = '²î';
		}

		System.out.println(score + ":" + grad);

	}
}
