package com.common.lambda;

public class MyTest {
	
	public void testAnimalSing(Animal a) {
		a.sing();
	}
	
	public static void main(String[] args) {
		MyTest test = new MyTest();
		//lamda最重要的功能是省略了匿名类在实现方法是的冗长代码
		//相当于只保留了匿名类在实现方法时的参数以及方法体
		test.testAnimalSing(()->System.out.println("hh"));
		test.testAnimalSing(new Dog() {
			@Override
			public void sing() {
				System.out.println("goubujiao");
			}
		});
	}
}
