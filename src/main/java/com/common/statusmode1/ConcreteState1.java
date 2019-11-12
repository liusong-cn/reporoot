package com.common.statusmode1;

public class ConcreteState1 implements State {

	@Override
	public void handle(Context c) {
		// TODO Auto-generated method stub
		c.setS(new ConcreteState2());
		System.out.println("执行状态1");
	}

}
