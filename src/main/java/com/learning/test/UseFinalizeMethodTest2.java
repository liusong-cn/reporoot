package com.learning.test;

public class UseFinalizeMethodTest2 {
	
	private boolean isReaded;
	
	public UseFinalizeMethodTest2(boolean isReaded) {
		this.isReaded = isReaded;
		//finalize被当成了普通方法直接调用
		finalize();
	}
	
	public void readBook() {
		isReaded = true;
	}
	
	protected void finalize() {
		System.out.println("调用finalize");
	}
	
	public static void main(String[] args) {
		new UseFinalizeMethodTest2(true);
		new UseFinalizeMethodTest2(false).readBook();
	}
}
