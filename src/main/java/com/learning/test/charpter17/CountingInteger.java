package com.learning.test.charpter17;

import java.util.AbstractList;

public class CountingInteger extends AbstractList<Integer> {
	
	private int size;
	
	public CountingInteger(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
	}

	@Override
	public Integer get(int index) {
		// TODO Auto-generated method stub
		//此处是简单的通过index来产生一个与之相关的value
		//那么一般情况下可以在该类的内部存贮一个全集，通过index来取得对应的数据
		//此种容器需要在内部预先就有全集，而如果容器创建时并不知道容器内的元素是哪些那么就不适用这种模式
		//而应该转为add（）
		//享元模式比较受限，适用于在普通的解决方案中需要过多的对象，以及产生普通对象太占用空间时
		//是一个比较鸡肋的模式
		return Integer.valueOf(index);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
