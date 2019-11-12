package com.common.visitormode;

public class Boss extends AccountBillViewer {
	private String result;
	
	private double in;
	
	private double out;
	@Override
	public void viewInComeBill(IncomeBill income) {
		// TODO Auto-generated method stub
		in = income.getMoney();
	}

	@Override
	public void viewOutComeBill(OutComeBill outcome) {
		// TODO Auto-generated method stub
		out = outcome.getMoney();
	}
	
	public void getResult(){
		System.out.println(in-out);
	}

}
