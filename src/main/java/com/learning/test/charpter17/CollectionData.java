package com.learning.test.charpter17;

import java.util.ArrayList;

public class CollectionData<T> extends ArrayList<T> {
	
	//generator这个生成器让所有实现了该接口的类都可以通过ColletionData的初始化
	//由于可以根据需要选择不同的generator，从使用上来说很类似策略模式
	//但是在实现上其实就是一个实现接口的多态
	public CollectionData(Generator<T> gen, int quantity) {
		for (int i = 0; i < quantity; i++) {
			add(gen.next());
		}
	}
	
	public static <T> CollectionData<T> listGenerator(Generator<T> gen, int quantity){
		//构造CollectionData<T>的实例
		return new CollectionData<T>(gen, quantity);
	}
}
