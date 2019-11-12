package com.common.strategyMode;

public class CashContext {
	
	private CashSuper c;
	
	public CashContext(String type){
		switch (type) {
		case "打8折":
			c = new Cash1();
			break;

		default:
			c = new Cash2();
			break;
		}
	}
	
	public void getResult(double money){
		c.acceptMoney(money);
	}
}
