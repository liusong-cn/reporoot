package com.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("myProxy")
public class MyProxy implements IProxy {
	
	@Autowired
	private IRun myRun;
	
	@Override
	public void doProxy() {
		// TODO Auto-generated method stub
		myRun.run();
	}

}
