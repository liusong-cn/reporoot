package com.learning.test.charpter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListFunctionTest {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3);
		//使用arrays.asList构造的list，其底层被当成了数组，因此再向list中add、delete时会出错
		//list.add(2);
		System.out.println(list.toString());
		
		//使用collections工具类则不会出现此类问题
		Collection<Integer> c = new ArrayList<Integer>();
		Collections.addAll(c, 2,2,3);
		c.add(5);
		System.out.println(c.toString());
	}
}
