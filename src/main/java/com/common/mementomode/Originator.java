package com.common.mementomode;

/**
 * 发起者
 * @author Administrator
 *
 */
public class Originator {
	
	private String state;
	
	private Memento memento;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
	public void show(){
		System.out.println(state);
	}
	
	public Memento createMemento(){
		return new Memento(state);
	}
}
