package com.learning.test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FibonacciTest {
	
	
	public static void main(String[] args) {
		new FibonacciTest().showAllFibonacciNum(5);
	}
	
	public void showAllFibonacciNum(int count) {
		int[] fibonacci = new int[count];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		for (int i = 0; i < count - 2; i++) {
			fibonacci[i+2] = fibonacci[i+1] + fibonacci[i];
		}
		//使用arrays的工具方法
		System.out.println(Arrays.toString(fibonacci));
	}
}
