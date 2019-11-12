package com.learning.test;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberTest {
	
	public static void main(String[] args) {
		//记录1-100以内的素数,只能被自身和1整除的数
		List<Integer> intList = new ArrayList<Integer>();
		for(int i = 1;i < 101 ; i++) {
			int k = 0;
			for(int j  = 1;j <= i ;j++) {
				if( i%j == 0)
					k++;
			}
			if(k == 2)
				intList.add(i);
			
		}
		System.out.println(intList.toString());
	}
}
