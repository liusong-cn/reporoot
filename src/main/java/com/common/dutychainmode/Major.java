package com.common.dutychainmode;

public class Major extends Command {

	protected Major(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handRequest(Request request) {
		// TODO Auto-generated method stub
		if(request.getRequestNum() == 2){
			System.out.println("总监可以处理");
		}else {
			superior.handRequest(request);
		}
	}

}
