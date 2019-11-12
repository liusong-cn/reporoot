package com.common.commandmode;

public class Test {
	public static void main(String[] args) {
		Receiver r = new Receiver();
		Command c1  = new ConcreteCommand1(r);
		Command c2 = new ConcreteCommand2(r);
		Invoker in = new Invoker();
		in.addCommand(c1);
		in.addCommand(c2);
		in.executeAllCommand();
	}
}
