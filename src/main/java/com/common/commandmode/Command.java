package com.common.commandmode;

public abstract class Command {
	
	protected Receiver receiver;
	
	protected Command(Receiver receiver){
		this.receiver = receiver;
	}
	
	abstract protected void execute();
}
