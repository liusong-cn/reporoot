package com.learning.test;

public class ClassExtendsAbstract extends AbstractClassTest1{
	
	
	static void acceptBaseClass(AbstractClassTest1 t) {
		t.print();
	}
	
	public static void main(String[] args) {
		AbstractClassTest1 t = new ClassExtendsAbstract();
		ClassExtendsAbstract.acceptBaseClass(t);
	}

	@Override
	void print() {
		// TODO Auto-generated method stub
		System.out.println("hello1");
	}
}
