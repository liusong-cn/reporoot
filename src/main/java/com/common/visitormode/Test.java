package com.common.visitormode;

public class Test {
	
	public static void main(String[] args) {
		BillContainer container = new BillContainer();
		container.addBill(new IncomeBill("卖水", 3));
		container.addBill(new IncomeBill("卖烟", 3));
		container.addBill(new OutComeBill("买米", 5));
		container.addBill(new OutComeBill("买菜", 6));
		//两个访问者
		Boss boss = new Boss();
		Accountant accountant = new Accountant();
		
		//分别访问账单
		container.show(boss);
		container.show(accountant);
		
		
	}
}
