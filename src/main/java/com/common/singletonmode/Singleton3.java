package com.common.singletonmode;

/**
 * 线程同步，耗费资源多
 * @author Administrator
 *
 */
public class Singleton3 {
	
	private static Singleton3 instance;
	
	public static synchronized Singleton3 getInstance(){
		if(instance == null){
			instance = new Singleton3();
		}
		return instance;
	}
}
