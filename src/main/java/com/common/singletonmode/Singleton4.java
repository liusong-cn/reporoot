package com.common.singletonmode;

/**
 * 静态内部类实现线程安全单例
 * @author Administrator
 *
 */
public class Singleton4 {
	
	private static Singleton4 instance;
	
	private static class s4 {
		static final Singleton4 s = new Singleton4();
	}
	
	public static Singleton4 getInstance(){
		if(instance == null){
			instance = s4.s;
		}
		return instance;
	}
}
