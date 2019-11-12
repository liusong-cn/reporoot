package com.learning.test.charpter17;

public class GeneratorDemo {
	public static void main(String[] args) {
		CollectionData<String> c = CollectionData.listGenerator(new Government(), 3);
		//由于集成了arraylist，故此容器也具有arraylist的能力
		for (int i = 0; i < c.size(); i++) {
			System.out.println(c.get(i));
		}
	}
}
