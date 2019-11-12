package com.learning.test.charpter9;

public class ExchangeProcessor extends Processor {
	
	//通过继承，实现与基类不同的处理逻辑，和通过实现接口的方式不同，此处不需要override关键字
	public Object process(Object input) {
		return ((String)input).toUpperCase();
	}
}
