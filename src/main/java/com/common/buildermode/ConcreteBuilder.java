package com.common.buildermode;

public class ConcreteBuilder implements Builder {
	
	private Product product = new Product();

	@Override
	public void buildPartA() {
		// TODO Auto-generated method stub
		product.addPart("a");
	}

	@Override
	public void buildPartB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getResult() {
		// TODO Auto-generated method stub
		return product;
	}

}
