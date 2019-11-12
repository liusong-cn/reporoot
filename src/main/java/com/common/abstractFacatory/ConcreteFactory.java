package com.common.abstractFacatory;

public class ConcreteFactory extends AbstractFactory {

	@Override
	public AbstractProduct getProduct() {
		// TODO Auto-generated method stub
		return new ConcreteProduct();
	}

	@Override
	public AbstractProduct1 getProduct1() {
		// TODO Auto-generated method stub
		return new ConcreteProduct1();
	}

}
