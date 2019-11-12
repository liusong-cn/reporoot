package com.common.mediatormode;

public class Test {
	
	public static void main(String[] args) {
		ConcreteColleague1 c1 = new ConcreteColleague1();
		ConcreteColleague2 c2 = new ConcreteColleague2();
		ConcreteMediator m = new ConcreteMediator(c1, c2);
		c1.setM(m);
		c2.setM(m);
		c1.notifyColleage2();
		c2.notifyColleagueC1();
	}
}
