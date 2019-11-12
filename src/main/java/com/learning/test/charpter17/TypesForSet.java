package com.learning.test.charpter17;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TypesForSet {
	static <T> Set<T> fill(Set<T> set, Class<T> type){
		for (int j = 0; j < 10; j++) {
			try {
				//带参实例化，如果是不带参 type.newInstance(),调用默认的构造器
				set.add(type.getConstructor(int.class).newInstance(j));
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		return set;
	}
	
	static <T> void test(Set<T> set, Class<T> type) {
		fill(set,type);
		fill(set,type);//测试重复调用set
		System.out.println(set);
	}
	
	public static void main(String[] args) {
		test(new HashSet<HashType>(), HashType.class);
		test(new LinkedHashSet<HashType>(), HashType.class);
		System.out.println("------------");
		test(new TreeSet<TreeType>(),TreeType.class);
	}
}

class SetType {
	
	protected int i;
	
	public SetType(int i) {
		// TODO Auto-generated constructor stub
		this.i = i;
	}
	
	public boolean equals(Object o) {
		return o instanceof SetType&& i == ((SetType)o).i;
	}
	
	public String toString() {
		return String.valueOf(i);
	}
}

class HashType extends SetType{

	public HashType(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}
	
	public int hashCode() {
		//特定的hash算法，此种自定义的hash算法比较简单
		return i%2;
	}
	
}

class TreeType extends SetType implements Comparable<TreeType>{

	public TreeType(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(TreeType o) {
		// TODO Auto-generated method stub
		//比较时不要直接用i - o.i，因为i可以是一个很大的正整数，而o.i如果是一个很小的负整数时，两者相减就会溢出
		return i>o.i?-1:(i== o.i?0:1);
	}
	
}