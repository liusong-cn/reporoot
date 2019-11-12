package com.common.dutychainmode;

public class GeneralManager extends Command {

	protected GeneralManager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handRequest(Request request) {
		// TODO Auto-generated method stub
		if(request.getRequestNum() == 3){
			System.out.println("总经理可以处理");
		}else{
			superior.handRequest(request);
		}
	}

}
