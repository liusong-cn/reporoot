package com.common.statusmode1;

public class ConcreteState2 implements State {

	@Override
	public void handle(Context c) {
		// TODO Auto-generated method stub
		c.setS(new ConcreteState1());
		System.out.println("执行状态2");
	}

}
