package com.learning.test.charpter15;

public class ClassTypeDemo {
	
	private String name = "parent";
	
	public static void main(String[] args) {
		System.out.println(new ClassTypeDemo().getClass());
		//rtti机制使得在运行时可以争取额的获得引用对象的真实类型
		ClassTypeDemo d = new SonClassType();
		System.out.println(d.getClass());
	}
}

class SonClassType extends ClassTypeDemo{
	
}
