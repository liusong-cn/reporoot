package com.learning.test;

public class Fibonacci {
	
	//此种写法简洁易懂
	public int Fi(int i) {
		if(i<2) return i;
		return Fi(i-2) + Fi(i-1);
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		for (int i = 1; i < 5; i++) {
			System.out.println(f.Fi(i));
		}
	}
}
