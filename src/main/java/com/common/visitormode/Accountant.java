package com.common.visitormode;

public class Accountant extends AccountBillViewer {
	
	private double intax;
	
	private double outtax;
	
	@Override
	public void viewInComeBill(IncomeBill income) {
		// TODO Auto-generated method stub
		intax = income.getMoney()*0.1;
	}

	@Override
	public void viewOutComeBill(OutComeBill outcome) {
		// TODO Auto-generated method stub
		outtax = outcome.getMoney()*0.05;
	}
	
	public void addtax(){
		System.out.println(intax+outtax);
	}

}
