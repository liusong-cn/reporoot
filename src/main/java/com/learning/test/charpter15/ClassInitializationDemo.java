package com.learning.test.charpter15;

/**
 * 通过下面的例子可以看出jvm是动态初始化类的。spring的注册类功能应该并不是强制要求被注册的类一定初始化
 * @author Administrator
 *
 */
public class ClassInitializationDemo {
	
	static int d = 6;
	
	public static void main(String[] args) throws Exception {
		//通过.class属性并不会触发类初始化，初始化指如果类及类的父类含有初始化块时，会执行相应代码
		Class first = FirstClass.class;
		System.out.println("111");
		//此处由于调用的类的静态常量，不会初始化
		System.out.println(FirstClass.a);
		System.out.println("2222");
		//由于a1是非常数静态域，它使用了另一个类的域值，因此触发初始化
		System.out.println(FirstClass.a1);
		
		System.out.println("333");
		//本来调用类的静态方法时会触发初始化，此处由于前面已经触发了初始化，故不再初始化
		//总结:类如果有超类，或者对类的静态方法进行调用，或者引用了非常数静态域的值，都会对类进行初始化
		FirstClass.use();
		//通过此方式获得class对象的引用时需要用到类的全限定包名，不能使用相对路径
		//thinking in java 中的例子没有给正确
		//使用forName时会直接触发初始化
		Class Third = Class.forName("com.learning.test.charpter15.ThirdClass");
		System.out.println("444");
		//此处的b是静态域，但不是常数静态域，因此会触发初始化
		System.out.println(SecondClass.b);
		
	}
	
}

class FirstClass{
	static final int a = 1;
	static final int a1 = ClassInitializationDemo.d;
	static {
		System.out.println("first Class is initialized");
	}
	
	static void use(){
		System.out.println("调用静态方法");
	}
	
}

class SecondClass{
	//非常量静态域
	static  int b = 2;
	
	
	static {
		System.out.println("second class is initialized");
	}
}

class ThirdClass{
	static final int c = 3;
	static {
		System.out.println("third class is initialized");
	}
}
