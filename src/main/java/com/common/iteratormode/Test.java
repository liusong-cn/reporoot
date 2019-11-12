package com.common.iteratormode;



public class Test {
	
	public static void main(String[] args) {
		ConcreteAggrate c = new ConcreteAggrate();
		for (Iterator iterator = c.getIterator(); iterator.hashNext();) {
			String name = (String) iterator.next();
			System.out.println(name);
		}
	}
}
