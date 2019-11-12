package com.common.mediatormode;

public class ConcreteColleague1 extends Colleague {

	public void notifyColleage2(){
		m.notifyC2();
	}
	
	public void operate(){
		System.out.println("同事1处理");
	}
}
