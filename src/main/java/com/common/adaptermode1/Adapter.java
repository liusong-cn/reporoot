package com.common.adaptermode1;



//适配器
public class Adapter  extends Adaptee implements Target{
	

	@Override
	public void requestAdater() {
		//使用了父类adaptee的方法，此处可以加上控制等功能
		int age = getAge();
		System.out.println("此处没做限制，调用了适配者/被代理者的方法，使得target增加了能力");
	}
}
