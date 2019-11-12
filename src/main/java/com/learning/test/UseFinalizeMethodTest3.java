package com.learning.test;

public class UseFinalizeMethodTest3 {
	
	class Tank{
		private boolean empty;
		
		private Tank(boolean empty) {
			this.empty = empty;
		}
		
		public void checkEmpty() {
			empty = false;
		}
		
		protected void finalize() {
			//对象被清理时必须处于empty状态
			if(!empty) empty = true;	
		}
	}
	
	public static void main(String[] args) {
		new UseFinalizeMethodTest3().new Tank(true);
		new UseFinalizeMethodTest3().new Tank(false);
		System.gc();
		
	}
}
