package com.common.decoratemode;

public class Decorater implements Component {
	
	private Component component;
	
	public Decorater(Component component){
		this.component = component;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		component.show();
		System.out.println("父装饰了一次");
	}

}
