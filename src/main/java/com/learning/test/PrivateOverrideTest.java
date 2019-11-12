package com.learning.test;

public class PrivateOverrideTest {
	
	private void f() {System.out.println("private f()");}
	
	public static void main(String[] args) {
		PrivateOverrideTest p = new Derived();
		//由于private方法相当于 private final方法，即对子类不可见，
		//因此子类也不可能覆盖该方法，又因声明为父类，故此处调用时还是调用了父类的方法
		p.f();
		
		//此处可以正确调用子类自有的方法，但这样在面向接口编程时就无法使用里式替换了
		Derived p1 = new Derived();
		p1.f();
	}
	
	
}

class Derived extends PrivateOverrideTest{
	public void f() {System.out.println("public f()");}
}
