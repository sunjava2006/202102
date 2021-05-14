package com.thzhima.base;

public class ScoreGrad {

	public static void main(String[] args) {
		int score = (int) Math.round(Math.random() * 100);

		String grad = null;

		if (score >= 90) {
			grad = "优";
		} else if (score >= 80) {
			grad = "良";
		} else if (score >= 70) {
			grad = "中";
		} else if (score >= 60) {
			grad = "及格";
		} else {
			grad = "有待提高";
		}

		System.out.println(score + ":" + grad);
	}
}
