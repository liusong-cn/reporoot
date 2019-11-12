package com.common.decoratemode;

public class Test {
	
	public static void main(String[] args) {
		ConcreteComponent c = new ConcreteComponent();
		Decorater1 d1 = new Decorater1(c);
		d1.show();
		System.out.println("----");
		Decorater2 d2 = new Decorater2(d1);
		d2.show();
	}
}
