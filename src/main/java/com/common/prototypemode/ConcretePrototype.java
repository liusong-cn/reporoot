package com.common.prototypemode;

public class ConcretePrototype implements Prototype {
	
	private int num;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public Prototype Clone() {
		// TODO Auto-generated method stub
		ConcretePrototype c = new ConcretePrototype();
		c.setNum(num);
		return c;
	}

}
