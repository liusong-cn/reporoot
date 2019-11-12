package com.learning.test.charpter17;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 该例子使用了享元模式：常规的与对象有关的所有数据应该都在对象内部，而享元模式允许对象所需的所有数据不必在对象创建时就已经存在
 * 而是可以部分存在且通过generator产生数据，对象内部存贮的是该数据的一种索引
 * @author Administrator
 *
 */
public class Countries {
	//二维数组表示一维数组的数组，因此data[index][index1]表示第index个一维数组中的第index1个元素
	//此处相当于一个数据全集，后续的flaweightmap提供了如何获取该全集或部分集合的能力，再通过capitals（）来取得该部分集合
	public static String[][] data = {{"China","beijing"},{"America","washington"},{"Japan","tokyo"}};
	
	private static class FlyweightMap extends AbstractMap<String, String>{
		
		
		private static class Entry implements Map.Entry<String, String>{
			
			int index;
			
			public Entry(int index) {
				// TODO Auto-generated constructor stub
				this.index = index;
			}

			@Override
			public String getKey() {
				// TODO Auto-generated method stub
				return data[index][0];
			}

			@Override
			public String getValue() {
				// TODO Auto-generated method stub
				return data[index][1];
			}

			@Override
			public String setValue(String value) {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}
			
			public int hashCode() {
				return data[index][0].hashCode();
			}
			
		}
		
		static class EntrySet extends AbstractSet<Map.Entry<String, String>>{
			
			private int size;
			
			public EntrySet(int size) {
				// TODO Auto-generated constructor stub
				//三员表达式写起来还是很简洁， 少了很多if else
				this.size = size<0?0:(size<data.length?size:data.length);
			}
			
			private class Iter implements Iterator<Map.Entry<String, String>>{

				private Entry entry = new Entry(-1);
				
				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return entry.index < size - 1;
				}

				@Override
				public Map.Entry<String, String> next() {
					// TODO Auto-generated method stub
					entry.index++;
					return entry;
				}
				
			}
			
			@Override
			public Iterator<Map.Entry<String, String>> iterator() {
				// TODO Auto-generated method stub
				return new Iter();
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return size;
			}
			
		}
		
		private static Set<Map.Entry<String, String>> entries = new EntrySet(data.length);

		@Override
		public Set<Map.Entry<String, String>> entrySet() {
			// TODO Auto-generated method stub
			return entries;
		}
		
	}
	
	//final用于表示后续的size不会生效
	static Map<String, String> select(final int size){
		//后续的entrySet()其实是重写了AbstractMap<String, String>里的entrySet方法
		return new FlyweightMap() {
			public Set<Map.Entry<String, String>> entrySet(){
				return new EntrySet(size);
			}
		};
	}
	
	static Map<String,String> map = new FlyweightMap();
	
	public static Map<String, String> capitals(){
		return map;
	}
	
	public static Map<String, String> capitals(int size){
		return select(size);
	}
	
	static List<String> names = new ArrayList<String>(map.keySet());
	
	public static List<String> names(){
		return names;
	}
	
	public static List<String> names(int size){
		return new ArrayList<String>(select(size).keySet());
	}
	
	public static void main(String[] args) {
		System.out.println(capitals(2));
	}
}
