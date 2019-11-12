package com.learning.test.charpter17;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

//利用散列原理实现的map
public class SimpleHashMap<K,V> extends AbstractMap<K, V> {
	
	
	static final int size = 900;
	
	LinkedList<MapEntity<K,V>>[] buckets = new LinkedList[size];
	
	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode())%size;
		if(buckets[index] == null) {
			MapEntity m = new MapEntity(key, value);
			LinkedList<MapEntity<K,V>> list = new LinkedList<MapEntity<K,V>>();
			list.add(m);
			buckets[index] = list;
		}else {
			boolean found = false;
			ListIterator<MapEntity<K,V>> li = buckets[index].listIterator();
			while (li.hasNext()) {
				MapEntity<K, V> mapEntity = (MapEntity<K, V>) li.next();
				if(key.equals(mapEntity.getKey())) {
					oldValue = mapEntity.getValue();
					mapEntity.setValue(value);
					found = true;
					break;
					
				}
			}
			
			if(!found) {
				MapEntity map = new MapEntity(key, value);
				buckets[index].add(map);
			}
		}
		return oldValue;
	}
	
	//这个set用于去重数据,且是abstractmap所要求必须实现的
	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
		for (int i = 0; i < buckets.length; i++) {
			//mapentity实现了map.entity接口
			LinkedList<MapEntity<K, V>> linkedList = buckets[i];
			if(linkedList == null) continue;
			for (MapEntity<K, V> mapEntity : linkedList) {
				set.add(mapEntity);
			}
		}
		return set;
	}
	
	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % size;
		if(buckets[index] == null) return null;
		for (MapEntity<K, V> linkedList : buckets[index]) {
			if(key.equals(linkedList.getKey())) return linkedList.getValue();
		}
		return null;
	}

}
