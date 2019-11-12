package com.learning.test.charpter17;

public abstract class Test<C>{
	String name;
	
	public Test(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	abstract int test(C container, TestParam tp);
	
}
