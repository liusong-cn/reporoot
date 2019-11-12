package com.common.adaptermode;

public class Test {
	
	public static void main(String[] args) {
		Target t = new Adapter();
		t.request();
	}
}
