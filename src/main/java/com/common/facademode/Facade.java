package com.common.facademode;

public class Facade {
	
	private ModuleA a;
	
	private ModuleB b;
	
	private ModuleC c;
	
	public Facade(){
		a = new ModuleA();
		b = new ModuleB();
		c = new ModuleC();
	}
	
	public void test(){
		a.methodA();
		b.methodB();
		c.methodC();
	}
	
	public static void main(String[] args) {
		Facade f = new Facade();
		f.test();
	}
}
