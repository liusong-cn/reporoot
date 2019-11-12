package com.common.observer;

public class Test {
	
	public static void main(String[] args) {
		ConcreteSubject s = new ConcreteSubject();
		ConcreteObserver o = new ConcreteObserver();
		ConcreteObserver o1 = new ConcreteObserver();
		s.addObserver(o);
		s.addObserver(o1);
		s.doSomething();
	}
}
