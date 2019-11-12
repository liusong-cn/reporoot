package com.common.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
	
	private List<Observer> oList = new ArrayList<Observer>();
	
	public void addObserver(Observer observer){
		oList.add(observer);
	}
	
	public void deleteObserver(Observer observer){
		oList.remove(observer);
	}
	
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("我吃饭了");
		for (Observer observer : oList) {
			observer.update("他在吃饭");
		}
	}

}
