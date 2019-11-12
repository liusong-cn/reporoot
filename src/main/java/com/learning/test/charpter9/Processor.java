package com.learning.test.charpter9;

public class Processor {
	
	public String getName() {
		return getClass().getSimpleName();
	}
	//接收不同的操作参数，并对此做处理，此处的处理是直接返回
	public Object process(Object input) {return input;}
}
