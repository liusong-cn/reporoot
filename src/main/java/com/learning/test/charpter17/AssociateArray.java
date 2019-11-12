package com.learning.test.charpter17;

public class AssociateArray<K,V> {
	
	private int index;
	
	private Object[][] pairs;
	
	public AssociateArray(int length){
		pairs = new Object[length][2];
	}
	
	public V getValue(K k) {
		for (int i = 0; i < pairs.length; i++) {
			if(k.equals(pairs[i][0])) return (V) pairs[i][1];
		}
		return null;
	}
	
	//此方法中没有考虑key相同的情况
	public <K,V> void put(K k,V v) {
		if(index< pairs.length - 1) {
			//index指针的作用是用于指定新增加的pair对象数组的位置
			pairs[index++] = new Object[] {k,v};
		}else throw new ArrayIndexOutOfBoundsException();
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < index; i++) {
			sb.append(pairs[i][0] + ":" + pairs[i][1]);
			if(i<index -1) sb.append(",");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		AssociateArray<Integer, String> as = new AssociateArray<Integer, String>(5);
		as.put(1, "hello");
		as.put(2, "world");
		as.put(3, "python");
		as.put(4, "java");
		System.out.println(as);
	}
	
	

}
