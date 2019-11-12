package com.common.buildermode;

public class Director {
	
	public void construct(Builder builder){
		builder.buildPartA();
		builder.buildPartB();
	};
}
