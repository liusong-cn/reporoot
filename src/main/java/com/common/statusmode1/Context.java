package com.common.statusmode1;

public class Context {
	
	private State s;
	
	public Context(State s){
		this.s = s;
	}
	
	public State getS() {
		return s;
	}



	public void setS(State s) {
		this.s = s;
	}



	public void request(){
		s.handle(this);
	};
}
