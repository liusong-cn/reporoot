package com.learning.test;

public class EnumTest {
	
	private RMB r;
	
	public EnumTest(RMB r) {
		this.r = r;
	}
	
	public static void main(String[] args) {
		EnumTest et = new EnumTest(RMB.FEN);
		System.out.println(RMB.values().length);
		switch (et.r) {
		case FEN:
			System.out.println("这是分");
			break;
		/*
		 * case JIAO: System.out.println("这是角");
		 */
		default:
			System.out.println("这是元");
			break;
		}
	}
	
}
