package com.common.decoratemode;

public class Decorater2 extends Decorater {

	public Decorater2(Component component) {
		super(component);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void show(){
		super.show();
		System.out.println("子装饰器2");
	}

}
