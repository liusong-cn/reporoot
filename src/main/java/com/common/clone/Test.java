package com.common.clone;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		ConcretePrototype c = new ConcretePrototype();
		c.setName("zhangsan");
		List<String> names = new ArrayList<>();
		names.add("a");
		names.add("b");
		c.setNames(names);
		ConcretePrototype c1 = c.clone();
		System.out.println(c1.getName());
		System.out.println(c1.getNames());
		c1.setName("wang");
		System.out.println(c.getName());
		System.out.println(c1.getName());
		List<String> revise = c1.getNames();
		String b = revise.get(0);
		String a = revise.get(1);
		revise.set(0, a);
		revise.set(1, b);
		System.out.println(c1.getNames());
		System.out.println(c.getNames());
		//可以看出实现cloneable是浅克隆，克隆时克隆了对象，克隆了对象的值类型的属性，
		//对象的引用类型的属性只克隆了该引用，该变量还是指向原有对象的引用对象，并没有对引用对象进行克隆。
		//本例子中对原有对象的String类型的属性进行克隆时，由于String是final类型，不可更改，所以更改克隆之后的对象的该值，
		//在内存中新建了一个String,并且该克隆之后的对象的属性指向了内存中的新的string，而被克隆对象的指向没变。看起来像是实现了深克隆。
		//通过对克隆之后的对象其中某个类型为数组的属性的修改，发现修改了该数组后，被克隆对象的该属性对应的数组也发生了同步修改，就可以看出这是浅克隆，
		//对于对象的属性为引用类型的，只克隆了引用，没有克隆该引用的对象。实现深克隆需要实现serializable，引用对象也需要实现serializable.
	}
}	
