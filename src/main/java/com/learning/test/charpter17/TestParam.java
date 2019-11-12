package com.learning.test.charpter17;

public class TestParam {
	
	public final int size;
	
	public final int loop;
	
	public TestParam(int size, int loop) {
		// TODO Auto-generated constructor stub
		this.size = size;
		this.loop = loop;
	}
	
	public static TestParam[] array(int... values) {
		int size = values.length/2;
		int n = 0;
		TestParam[] tp = new TestParam[size];
		for (int i = 0; i < size; i++) {
			tp[i] = new TestParam(values[n++], values[n++]);
		}
		return tp;
	}
	
	public static TestParam[] array(String[] vals) {
		int[] v = new int[vals.length];
		for (int i = 0; i < v.length; i++) {
			v[i] = Integer.decode(vals[i]);
		}
		return array(v);
	}
	
	
}
