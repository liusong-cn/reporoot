package com.learning.test.charpter17;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HashCodeTest {
	
	public static void main(String[] args) {
		HashCodeTest t = new HashCodeTest();
		Map<Groundhog, Prediction> map = new HashMap<Groundhog, Prediction>();
		t.weatherDetection(map, Groundhog.class);
		System.out.println(map);
		Groundhog gh = new Groundhog(3);
		System.out.println(map.containsKey(gh));
	}
	
	//使用泛型的目的在于容器可以容纳groundhog的子类，虽然一般的继承不声明泛型也可以实现
	//但是此处使用后可以明确告诉用户应该使用groundhog及其子类均可以构造groundhog类型
	//且在实现时使用了反射来生成groundhog类型
	public <T extends Groundhog> void weatherDetection(Map<Groundhog, Prediction> weatherMap,Class<T> type) {
		try {
			Constructor<Groundhog> c = (Constructor<Groundhog>) type.getConstructor(int.class);
			for (int i = 0; i < 10; i++) {
				Groundhog gh = c.newInstance(i);
				Prediction p = new Prediction();
				weatherMap.put(gh, p);
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(weatherMap);
		
	}
}

class Groundhog {
	private int number;
	
	public Groundhog(int number) {
		// TODO Auto-generated constructor stub
		this.number = number;
	}
	
	public String toString() {
		return "this is groudhog" + number;
	}
	
	public int hashCode() {
		return number;
	}
	
	
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	//重定义了hashcode方法和equals方法之后在例子中的判断key是否存在正式生效
	public boolean equals(Object o) {
		/*
		 * if(o instanceof Groundhog ) { Groundhog g = (Groundhog)o; if(g.getNumber() ==
		 * number) return true; } return false;
		 */
		//写法更简洁
		return o instanceof Groundhog && ((Groundhog)o).getNumber() == number;
	}
}

class Prediction{
	private static Random r  = new Random(43);
	
	private boolean shadow = r.nextLong() > 0.8	;
	
	public String toString() {
		if(shadow) return "winter is coming";
		return "early spring";
	}
}
