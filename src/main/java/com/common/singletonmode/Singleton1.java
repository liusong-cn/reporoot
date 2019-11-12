package com.common.singletonmode;

public class Singleton1 {
	
	private static Singleton1 instance;
	
	public static Singleton1 getInstance(){
		if(instance == null){
			instance = new Singleton1();
		}
		return instance;
	}
}
