package com.learning.test;

public class HpPrinter extends AbstractPrint {
	
	public int a = 2;

	@Override
	void print() {
		// TODO Auto-generated method stub
		System.out.println("this is hpprinter" + a);
	}
	
	public static void main(String[] args) {
		AbstractPrint ap = new HpPrinter();
		ap.print();
	}
}
