package com.common.abstractFacatory;

public class ConcreteFactory1 extends AbstractFactory {

	@Override
	public AbstractProduct getProduct() {
		// TODO Auto-generated method stub
		return new ConcreteProducta();
	}

	@Override
	public AbstractProduct1 getProduct1() {
		// TODO Auto-generated method stub
		return new ConcreteProducta1();
	}

}
