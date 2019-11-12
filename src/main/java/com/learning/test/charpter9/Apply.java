package com.learning.test.charpter9;

public class Apply {
	
	private static String s = "hello world";
	
	//将操作类和操作的参数分开，分别对操作类和操作参数使用不同的实现，以此来达到解耦的过程
	public static void process(Processor p ,Object s) {p.process(s);}
	
	
}
