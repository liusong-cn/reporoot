package com.common.statusmode1;

public class Test {
	public static void main(String[] args) {
		Context c = new Context(new ConcreteState1());
		for (int i = 0; i < 6; i++) {
			c.request();
		}
	}
}
