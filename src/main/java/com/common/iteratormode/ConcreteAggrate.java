package com.common.iteratormode;

public class ConcreteAggrate implements Aggreate {
	
	public String[] names = {"1","2","3"};
	
	/**
	 * 迭代器将被迭代的事物本身共有的遍历操作用一个公共接口Iterator来表示，
	 * 所有被迭代的事物都有这些功能需求
	 * 然而被迭代的事物自身的数据结构却可能不一样，因此具体的迭代器设计交由被迭代事物自己来设计
	 * 这样将被迭代事物的操作需求和自身的结构实现了解耦，是一种很牛逼的方式
	 * 在java中各类容器list set map都有自身不同的数据结构，而他们共有的操作需求是需要遍历以及取出其中的某个数据
	 * 因此用一个公共的功能接口Iterator来表示功能需求，在各类容器的实现类里去制定自身的遍历功能实现，而且在容器本身上增加了
	 * 泛型选项，因此可以接受各类数据，当然这也是容器本身所应该实现的功能
	 */
	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new NameIterator();
	}
	
	
	private class NameIterator implements Iterator{
		int index;
		
		@Override
		public boolean hashNext() {
			return index != names.length - 1;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(hashNext()){
				return names[index++];
			}
			return null;
		}
		
	}
}
