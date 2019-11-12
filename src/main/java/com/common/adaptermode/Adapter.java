package com.common.adaptermode;

public class Adapter extends Target {
	
	private Adaptee adaptee = new Adaptee();
	
	//此处更像是代理模式的运用，而非适配器模式，当然两者确实很像
	public void request(){
		System.out.println("转换成调用实际接口");
		adaptee.specificRequest();
	}
}
