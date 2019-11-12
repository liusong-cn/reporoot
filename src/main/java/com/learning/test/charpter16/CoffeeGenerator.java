package com.learning.test.charpter16;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee> {
	
	
	private int size;
	
	public CoffeeGenerator() {}
	
	
	public CoffeeGenerator(int size) {
		super();
		this.size = size;
	}

	
	private Class[] type = {Coffee.class,BlackCoffee.class,ItalianCoffee.class};
	
	private Random r = new Random(5);
	
	@Override
	public Coffee next() {
		try {
			return (Coffee) type[r.nextInt(type.length)].newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	class CoffeeIterator implements Iterator<Coffee>{
		
		int count = size;
		

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return count>0;
		}

		@Override
		public Coffee next() {
			// TODO Auto-generated method stub
			count--;
			//类名.this来引用外部类
			return CoffeeGenerator.this.next();
		}
		
	}
	
	public Iterator<Coffee> iterator(){
		return new CoffeeIterator();
	}

}
