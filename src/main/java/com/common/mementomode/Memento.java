package com.common.mementomode;

/**
 * 备忘录
 * @author Administrator
 *
 */
public class Memento {
	
	private String state;
	
	public Memento(String state){
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
