package com.common.adaptermode;

public class Adapter extends Target {
	
	private Adaptee adaptee = new Adaptee();
	
	//此处更像是代理模式的运用，而非适配器模式，当然两者确实很像
	//adaptee和target本身并没有关系，但是通过adapter使得target可以调用adaptee的方法
	//并且没有改变adaptee的功能，adaptee对使用方来说透明，通过多个适配器，可以使得adaptee被不断重用
	//符合新增开，对修改关闭原则
	public void request(){
		System.out.println("转换成调用实际接口");
		adaptee.specificRequest();
	}
}
