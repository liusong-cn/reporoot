package com.common.abstractFacatory;

public class Test {
	
	public static void main(String[] args) {
		
		AbstractFactory f = new ConcreteFactory();
		AbstractProduct p  = f.getProduct();
		AbstractProduct1 p1 = f.getProduct1();
		p.insertProduct();
		p1.insertProduct();
		//第二个工厂
		AbstractFactory f1 = new ConcreteFactory1();
		AbstractProduct pa = f1.getProduct();
		AbstractProduct1 pa1 = f1.getProduct1();
		pa.insertProduct();
		pa1.insertProduct();
	}
}
