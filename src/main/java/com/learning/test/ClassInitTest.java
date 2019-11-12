package com.learning.test;

public class ClassInitTest {
	
	private String a;
	
	
	
	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public ClassInitTest(String a) { this.a = a;System.out.println("a=" + a);}
	
	public static void main(String[] args) {
		ClassInitTest[] initArray = new ClassInitTest[3];
		//此种方式下classInitTest构造函数没有被执行。
		for (ClassInitTest classInitTest : initArray) {
			//classInitTest.getA();
		}
	}
}
