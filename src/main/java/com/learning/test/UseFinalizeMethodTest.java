package com.learning.test;

public class UseFinalizeMethodTest {
	
	private boolean bookReaded;
	
	public UseFinalizeMethodTest(boolean isReaded){
		bookReaded = isReaded;
	}
	
	public void readBook() {
		bookReaded = true;
	}
	protected void finalize() {
		if(!bookReaded) System.out.println("book is not readed");
	}
	
	public static void main(String[] args) {
		//gc在回收之前调用finalize（），从而执行特定代码
		new UseFinalizeMethodTest(false).readBook();
		new UseFinalizeMethodTest(false);
		System.gc();
	}
}
