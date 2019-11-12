package com.learning.test.charpter17;

public class Pair2<K,V>  {
	
	private final K k;
	
	private final V v;

	public Pair2(K k, V v) {
		//隐式继承object
		super();
		this.k = k;
		this.v = v;
	}

	public K getK() {
		return k;
	}

	public V getV() {
		return v;
	}

	

}
