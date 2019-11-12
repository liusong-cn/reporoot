package com.learning.test.charpter17;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//内部使用了list实现的map
public class SlowMap<K,V> extends AbstractMap<K, V>{
	
	private List<K> keyList = new ArrayList<>();
	
	private List<V> valueList = new ArrayList<V>();
	
	public V put(K key, V value) {
		V oldValue = get(key);
		if(!containsKey(key)) {
			keyList.add(key);
			valueList.add(value);
		}else {
			valueList.set(keyList.indexOf(key), value);
		}
		return oldValue;
	}
	
	//abstractmap本身实现了get（k key）,此处是一个重载方法
	public V get(Object key) {
		return containsKey(key)?valueList.get(keyList.indexOf(key)):null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> setMap = new HashSet<Entry<K,V>>();
		Iterator<K> ikey = keyList.iterator();
		Iterator<V> ivalue = valueList.iterator();
		while (ikey.hasNext()) {
			setMap.add(new MapEntity(ikey.next(), ivalue.next()));
		}
		return setMap;
	}
	
	public static void main(String[] args) {
		SlowMap<String, String> slow = new SlowMap<String, String>();
		slow.putAll(Countries.capitals(3));
		System.out.println(slow);
	}

}

//这个vo实现了map内部的entity接口
class MapEntity<K,V> implements Map.Entry<K, V>{
	
	private K key;
	
	private V value;

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public V setValue(V value) {
		// TODO Auto-generated method stub
		V result = this.value;
		this.value = value;
		return result;
	}
	
	public int hashCode() {
		//使用阶乘来作为hashcode
		return (key==null?0:key.hashCode())^(value== null?0:value.hashCode());
	}
	
	public boolean equals(Object o) {
		if(!(o instanceof MapEntity) ) return false;
		MapEntity me = (MapEntity)o;
		return (key==null?me.getKey()==null:me.getKey().equals(key))&& (value==null?me.getValue()==null:value.equals(me.getValue()));
	}
	
	public String toString() {
		return key + ":" + value;
	}
	
	
	
	public MapEntity(K key, V value) {
		this.key = key;
		this.value = value;
		// TODO Auto-generated constructor stub
	}
	
}
