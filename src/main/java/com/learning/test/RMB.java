package com.learning.test;

public enum RMB {
	
	//enum最基础的写法不需要构造函数，属性等等，只需要枚举值就可以
	//也不需要在末尾用；表示结束，末尾也允许有一个，
	//使用带属性和构造函数以及方法的enum的目的是既可以拿到枚举值，又可以拿到该枚举值对应的一些其他想要的东西
	//使用enum的场景：应该是常量数量有限以及表达比较明确的地方
	FEN(1),M(2);
	
	int value;
	
	RMB(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	
}
