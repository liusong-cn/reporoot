package com.common.singletonmode;

public class Test {
	public static void main(String[] args) {
		Singleton1 s1 = Singleton1.getInstance();
		System.out.println(s1);
		System.out.println(Singleton1.getInstance());
		
		Singleton2 s2 = Singleton2.getInstance();
		
		Singleton4 s4 = Singleton4.getInstance();
		System.out.println(s4);
		System.out.println(Singleton4.getInstance());
	}
}
