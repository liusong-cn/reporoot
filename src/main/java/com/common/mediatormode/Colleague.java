package com.common.mediatormode;

public abstract class Colleague {
	
	protected Mediator m;

	public Mediator getM() {
		return m;
	}

	public void setM(Mediator m) {
		this.m = m;
	}
	
	
}
