package com.common.decoratemode;

public class Decorater1 extends Decorater {
	
	
	
	public Decorater1(Component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void show(){
		super.show();
		System.out.println("子装饰器1");
	}
	
}
