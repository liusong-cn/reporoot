package com.common.dutychainmode;

public abstract class Command {
	
	protected String name;
	
	protected Command(String name){
		this.name = name;
	}
	
	protected Command superior;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Command getSuperior() {
		return superior;
	}

	public void setSuperior(Command superior) {
		this.superior = superior;
	}
	
	public abstract void handRequest(Request request);
}
