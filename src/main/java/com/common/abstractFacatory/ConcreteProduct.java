package com.common.abstractFacatory;

public class ConcreteProduct extends AbstractProduct {
	
	
	@Override
	public void insertProduct() {
		// TODO Auto-generated method stub
		System.out.println("11");
	}

	@Override
	public AbstractProduct getProduct() {
		// TODO Auto-generated method stub
		return this;
	}

}
