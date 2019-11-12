package com.learning.test.charpter17;

import java.util.Iterator;

public class Letters implements Generator<Pair2<Integer,String>>, Iterable<Integer> {
	
	private int number;
	
	private int size = 9;
	
	private char letter = 'A';
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return number < size;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return number++;
			}
			
		};
	}

	@Override
	public Pair2<Integer, String> next() {
		// TODO Auto-generated method stub
		return new Pair2<Integer, String>(number++, ""+ letter++);
	}

}
