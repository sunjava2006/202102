package com.thzhima.base.work;

public class 练习3 {

	public static void main(String[] args) {
		/********************************************************
		 * 企业发放的奖金根据利润提成。利润低于或等于10万元时，奖金可提10%；
		 * 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，
		 * 高于10万元的部分，可提成7.5%；
		 * 20万到40万之间时，高于20万元的部分，可提成5%；
		 * 40万到60万之间时高于40万元的部分，可提成3%；
		 * 60万到100万之间时，高于60万元的部分，可提成1.5%，
		 * 高于100万元时，超过100万元的部分按1%提成，
		 * 在程序中设定一个变量为当月利润，求应发放奖金总数？
		 ********************************************************/
		long amount = 1200000;  // 5600+6000+
		double commition = 0; // 奖金
		if(amount > 1000000) {
			commition += (amount -1000000) * 0.01;
			amount = 1000000;
		}
		if(amount >600000 && amount <=1000000) {
			commition += (amount-600000) * 0.015;
			amount = 600000;
		}
		if(amount >400000 && amount <=600000) {
			commition += (amount-400000) * 0.03;
			amount = 400000;
		}
		if(amount >200000 && amount <=400000) {
			commition += (amount-200000) * 0.05;
			amount = 200000;
		}
		if(amount >100000 && amount <= 200000) {
			commition += (amount-100000) * 0.075; // 1500
			amount =  100000;
		}
		if(amount <= 100000) {
			commition += amount * 0.1; // 10000
		}
		System.out.println(commition);
		
		System.out.println("=====================================================");
		
		long[] arr = {1000000, 600000, 400000, 200000, 100000,0};
		double[] rat = {0.01, 0.015, 0.03, 0.05, 0.075, 0.1};
		
		amount =1200000;
		commition = 0;
		
		for(int i=0; i<arr.length;i++) {
			if(amount > arr[i]) {
				commition += (amount-arr[i])*rat[i];
				amount = arr[i];
			}
		}
		System.out.println(commition);
	}
}
