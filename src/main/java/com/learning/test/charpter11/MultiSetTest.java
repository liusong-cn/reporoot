package com.learning.test.charpter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class MultiSetTest {
	
	//手写的生成器
	class NameGenerator{
		private String[]  movieNames = {"Snow White","Star Wars","League of Revengers","Gogila"};
		
		private int index = 0;
		
		String next() { 
			/*
			 * String s = Arrays.asList(movieNames).get(index); index++; return s;
			 */
			//i++用在语句中时，表示当前任然使用之前的值，待该语句执行完毕后再进行自增1；
			return Arrays.asList(movieNames).get(index++);
		}
		
		boolean hasNext() {
			return index <= movieNames.length - 1;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		LinkedList<String> ll = new LinkedList<String>();
		HashSet<String> hs = new HashSet<String>();
		TreeSet<String> ts = new TreeSet<String>();
		
		MultiSetTest mst = new MultiSetTest();
		NameGenerator n1 = mst.new NameGenerator();
		NameGenerator n2 = mst.new NameGenerator();
		NameGenerator n3 = mst.new NameGenerator();
		NameGenerator n4 = mst.new NameGenerator();
		
		while (n1.hasNext()) {
			al.add(n1.next());
			ll.add(n2.next());
			hs.add(n3.next());
			ts.add(n4.next());
		}
		al.iterator();
		System.out.println(al.toString());
		System.out.println(ll.toString());
		System.out.println(ts.toString());
		System.out.println(hs.toString());
	
	}
}
