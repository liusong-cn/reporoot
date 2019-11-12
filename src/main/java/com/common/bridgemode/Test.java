package com.common.bridgemode;

public class Test {
	public static void main(String[] args) {
		Bridge  b = new MyBridge();
		Driver mysql = new MysqlDriver();
		Driver oracle = new OracleDriver();
		
		b.setDriver(mysql);
		b.run();
		b.setDriver(oracle);
		b.run();
	}
}
