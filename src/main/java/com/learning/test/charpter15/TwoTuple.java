package com.learning.test.charpter15;

import java.io.File;

/**
 * 二维元组,元组的目的在于将多个对象打包至一个对象来存贮,元组的元素含有隐含的顺序，如下例所示
 * @author Administrator
 *
 */
public class TwoTuple <A,B>{
	public final A first;
	
	public final B second;
	
	public TwoTuple(A a, B b) {
		// TODO Auto-generated constructor stub
		first = a;
		second = b;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(first:" + first + ",second:" + second + ")";
	}
	
	public static void main(String[] args) {
		TwoTuple<Double, String > two = new TwoTuple<Double,String>((double)2, "3");
		System.out.println(two.first + "," +two.second);
		ThreeTuple<Double, String,Float> three = new ThreeTuple<Double, String, Float>((double)2, "3", (float)4);
		System.out.println(three);
	}
}

class ThreeTuple<A,B,C> extends TwoTuple<A,B>{
	
	public final C third;

	public ThreeTuple(A a, B b,C c) {
		super(a, b);
		// TODO Auto-generated constructor stub
		third = c;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(fisrt:" + first + ",second:" + second + ",third:" + third + ")";
	}
	
} 
