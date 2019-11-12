package com.learning.test.charpter16;

public class DotNew {
	
	class Inner{}
	
	public static void main(String[] args) {
		DotNew dotNew = new DotNew();
		//创建外部类的内部类时，需要外部类的实例引用来创建内部类
		Inner in = dotNew.new Inner();
	}
}	
