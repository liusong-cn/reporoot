package com.common.commandmode;

public class ConcreteCommand2 extends Command{

	protected ConcreteCommand2(Receiver receiver) {
		super(receiver);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		receiver.doOther();
	}
	
	

}
