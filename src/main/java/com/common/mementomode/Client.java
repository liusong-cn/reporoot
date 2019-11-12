package com.common.mementomode;

public class Client {
	
	public static void main(String[] args) {
		Originator o = new Originator();
		o.setState("on");
		o.show();
		Caretaker c = new Caretaker();
		c.setMemento(o.createMemento());
		o.setState("off");
		o.show();
		o.setState(c.getMemento().getState());
		o.show();
		//看不出备忘录模式的设计好处
	}
}
