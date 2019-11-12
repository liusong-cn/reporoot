package com.common.observer;

public class ConcreteObserver implements Observer {
	
	
	@Override
	public void update(String s) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass()+ s );
	}

}
