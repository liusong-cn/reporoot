package com.common.commandmode;

public class ConcreteCommand1 extends Command {

	protected ConcreteCommand1(Receiver receiver) {
		super(receiver);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		receiver.doSomething();
	}

}
