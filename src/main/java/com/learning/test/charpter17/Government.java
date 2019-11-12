package com.learning.test.charpter17;

public class Government implements Generator<String> {
	
	private String[] found = {"beijing","nanjing","chengdu"};
	
	private int index;
	
	
	@Override
	public String next() {
		// TODO Auto-generated method stub
		return found[index++];
	}

}
