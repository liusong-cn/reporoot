package com.learning.test.charpter17;

public class Pair<K,V> implements PairGenerator<K,V> {
	
	private K k;
	
	private V v;
	
	public Pair(K k, V v){
		this.k = k;
		this.v = v;
	}
	
	@Override
	public V next(K k) {
		// TODO Auto-generated method stub
		return v;
	}

}
