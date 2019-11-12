package com.common.interpretmode;

public class ActionNode extends Node {
	
	private String action;
	
	public ActionNode(String action){
		this.action = action;
	}
	
	@Override
	public void interpret() {
		// TODO Auto-generated method stub
		switch (action) {
		case "walk":
			System.out.println("走路");
			break;
		case "run":
			System.out.println("跑步");
			break;
		case "jump":
			System.out.println("跳");
			break;

		default:
			System.out.println("方式参数不合法");
			break;
		}
	}

}
