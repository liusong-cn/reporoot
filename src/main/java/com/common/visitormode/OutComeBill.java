package com.common.visitormode;

public class OutComeBill implements Bill {

	private String item;
	
	private double money;
	
	public OutComeBill(String item, double money){
		this.item = item;
		this.money = money;
	}
	
	@Override
	public void accept(AccountBillViewer abv) {
		// TODO Auto-generated method stub
		abv.viewOutComeBill(this);
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

}
