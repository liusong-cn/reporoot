package com.common.dutychainmode;

public class Manager extends Command {

	protected Manager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handRequest(Request request) {
		// TODO Auto-generated method stub
		if(request.getRequestNum() == 1){
			System.out.println("经理可以处理");
		}else {
			superior.handRequest(request);
		}
	}

}
