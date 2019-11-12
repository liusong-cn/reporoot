package com.learning.test.charpter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TernaryExpressionDemo {
	
	static class Integer implements Comparator<Integer>{
		
		private int i;
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			//嵌套的三元表达式
			return o1.i>o2.i?1:(o1.i== o2.i?0:-1);
		}
		
	}
	
	public static void main(String[] args) {
		Integer in1 = new Integer();
		Integer in2 = new Integer();
		Integer in3 = new Integer();
		in1.i = 1;
		in2.i = 2;
		in3.i = 3;
		List<Integer> inList = new ArrayList<Integer>();
		inList.add(in3);
		inList.add(in2);
		inList.add(in1);
		
		
	}
}
