package com.common.prototypemode;

public class MyClient {
	
	private Prototype p;
	
	public Prototype getP() {
		return p;
	}

	public void setP(Prototype p) {
		this.p = p;
	}

	public void operation(Prototype c){
		p = c;
		Prototype p2 = p.Clone();
		Prototype p3 = p.Clone();
	}
}
