package com.common.adaptermode1;

public class AdapterModeDemo {
	
	public static void main(String[] args) {
		Target t = new Adapter();
		t.requestAdater();
	}
}
