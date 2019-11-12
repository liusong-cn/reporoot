package com.learning.test;

import java.util.ArrayList;
import java.util.Random;

public class RandomTest {
	
	public static void main(String[] args) {
		//由于使用了同一个种子seed生成，因此每次调用都会生成同样的随机数
		Random random = new Random(20);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(random.nextInt(50));
		list.add(random.nextInt(50));
		//使用了lambda表达式来对list的每个元素进行迭代
		list.forEach(n->System.out.println(n));
	}
}
