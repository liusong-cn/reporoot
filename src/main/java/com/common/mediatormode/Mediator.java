package com.common.mediatormode;

public abstract class Mediator {
	
	protected ConcreteColleague1 c1;
	
	protected ConcreteColleague2 c2;
	
	public Mediator(ConcreteColleague1 c1, ConcreteColleague2 c2){
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public abstract void notifyC1();
	
	public abstract void notifyC2();
	
}
