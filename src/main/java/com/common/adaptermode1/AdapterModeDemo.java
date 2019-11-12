package com.common.adaptermode1;

public class AdapterModeDemo {
	
	public static void main(String[] args) {
		Tartget t = new Tartget();
		Adaptee e = new  Adaptee();
		Adapter ae = new Adapter();
		//此处的适配器模式看着就像是返回同样类型的值的不同方法，这种就很常见了
		//但是从思想上来说不一样，首先，两者都是具有同样功能的类，通过继承关系实现
		//然后代理者在原有接口类型功能的基础上想要进一步开发新的功能，比如这里的getAge1，
		//假定getAge1方法内部本身返回的并不是int，因此就无法和原有接口继续通信，因此在getAge1内部进行了转换，使得其结果能够
		//适配原有接口的类型，因此增加了类型相同的功能，同时没有破坏原有的功能
		//单从形式上来看如果是两个不相干的类，只要方法返回的值是同一个类型，那么都可以被原有的调用者调用
		//但是此处侧重于不仅和原有功能类似，可以理解为和原有的类相似，同时还新增了一个拓展功能来适配原有调用者的调用方式
		 t.request(e.getAge());
		 t.request(ae.getAge1());
	}
}
