package com.learning.test;

public class UseLable2ControllProcessTest {
	public static void main(String[] args) {
		outerlable:
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(j == 20)continue;
				//用于跳出内外层循环，其作用相当于goto
				if(j == 40) break outerlable;
				System.out.println("i = " + i + ", j = " + j);
			}
		}
	}
}
