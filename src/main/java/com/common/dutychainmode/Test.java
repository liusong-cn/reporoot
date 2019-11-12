package com.common.dutychainmode;

public class Test {
	
	public static void main(String[] args) {
		Manager m = new Manager("经理");
		Major major = new Major("总监");
		GeneralManager gm = new GeneralManager("总经理");
		m.setSuperior(major);
		major.setSuperior(gm);
		
		Request r = new Request();
		r.setRequestNum(1);
		m.handRequest(r);
		
		r.setRequestNum(2);
		m.handRequest(r);
		
		r.setRequestNum(3);
		m.handRequest(r);
	}
}
