package com.learning.test.charpter17;

import java.util.LinkedHashMap;
/**
 * 本例有点像一个工具方法，出了对于泛型的使用以外，本例在于将linkedhashmap的组装元素的功能进行了封装
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
public class MapData<K,V> extends LinkedHashMap<K, V> {
	//正是由于使用了泛型参数，将generator内部整体作为一个T对待，后续再展开T，求得其真实类型
	public MapData(Generator<Pair2<K,V>> gen, int quantity) {
		for (int i = 0; i < quantity; i++) {
			Pair2<K,V> pair = gen.next();
			put(pair.getK(),pair.getV());
		}
	}
	
	public static <K,V> MapData<K,V> map(Generator<Pair2<K,V>> gen, int quantity){
		return new MapData<K,V>(gen,quantity);
	}
	
	public static void main(String[] args) {
		//此种方式为手动调用构造器
		MapData<Integer,String> mapData = new MapData<Integer, String>(new Letters(), 11);
		//由于继承了linkedhashmap，其默认的toString方法会生成键值对数组
		System.out.println(mapData);
		//此种方式创建看起来是调用了类的静态方法，从底层来说依然是调用了构造器，节省了new的过程，看起来高级
		System.out.println(MapData.map(new Letters(), 11));
	}
}
