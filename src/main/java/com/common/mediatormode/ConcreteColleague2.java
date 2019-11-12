package com.common.mediatormode;

public class ConcreteColleague2 extends Colleague {

	public void notifyColleagueC1(){
		m.notifyC1();
	}
	
	public void operate(){
		System.out.println("同事2处理");
	}
}
