package com.common.mediatormode;

public class ConcreteMediator extends Mediator {

	public ConcreteMediator(ConcreteColleague1 c1, ConcreteColleague2 c2) {
		super(c1, c2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void notifyC1() {
		// TODO Auto-generated method stub
		c1.operate();
	}

	@Override
	public void notifyC2() {
		// TODO Auto-generated method stub
		c2.operate();
	}

}
