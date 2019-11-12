package com.common.bridgemode;

public abstract class Bridge {
	
	protected Driver driver;
	
	protected void setDriver(Driver driver){
		this.driver = driver;
	}
	
	abstract void run();
}
