package com.learning.test;

public class PrimaryDataTest {
	
	public static void main(String[] args) {
		char c = 'x';
		Character cw = new Character(c);
		//基础类型自动向包装类型转换
		cw = 'y';
		//包装类型自动向基础类型转换
		char d = cw;
		
		//对象类型的数组，虽然常用基本类型的数组
		Person[] p = {new Person(1, "lisi"),new Person(1, "wangwu")};
		//通过先声明，后赋值的方式创建数组
		Person[] p1 = new Person[2];
		p1[0] = new Person(10, "liu");
		p1[1] = new Person(11, "song");
		
		Student[] s = new Student[2];
		//创建动态内部类对象时需确保外部类实例必须存在
		s[0] = new PrimaryDataTest().new Student();
	}
	
	//动态内部类，没有使用static关键字修饰
	class Student{
		String name;
		
		String className;
		
		Student(){
			
		}
	}
	
	
}
