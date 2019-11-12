package com.common.strategyMode;

public class MyClientTest {
	
	/**
	 * 策略模式的核心在于对用户来说，其调用的方法不变，根据策略不同去选择方法的具体实现。
	 * @param args
	 */
	public static void main(String[] args) {
		CashContext c = new CashContext("打8折");
		c.getResult(100);
	}
}	
