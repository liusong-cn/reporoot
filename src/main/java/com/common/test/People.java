package com.common.test;

import org.springframework.stereotype.Component;

@Component
public class People {
	
	private String name;
	
	private String sex;
	
	public void eat(){
		System.out.println("人吃饭");
	}
}
