package com.common.buildermode;

public class Test {
	
	public static void main(String[] args) {
		ConcreteBuilder c = new ConcreteBuilder();
		Director d = new Director();
		d.construct(c);
		Product p = c.getResult();
		p.show();
		
	}
	
}
