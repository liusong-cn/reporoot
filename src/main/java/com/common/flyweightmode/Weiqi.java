package com.common.flyweightmode;

public abstract class Weiqi {
	
	protected String color;
	
	protected Weiqi(String color){
		this.color = color;
	}
	
	protected abstract void display(Coordination c);
	
}
