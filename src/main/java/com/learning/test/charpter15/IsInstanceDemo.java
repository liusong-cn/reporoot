package com.learning.test.charpter15;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class IsInstanceDemo {
	
	public static void main(String[] args) {
		ArrayList<String> strList = new ArrayList<String>();
		//动态判断某个对象是否是某个具体类的实例
		System.out.println(ArrayList.class.isInstance(strList));
		System.out.println(List.class.isInstance(strList));
		System.out.println(LinkedList.class.isInstance(strList));
		
		//静态判断某个对象的类型
		if(strList instanceof ArrayList) {
			System.out.println("isArraylist");
		}
		
		if(strList instanceof List) {
			System.out.println("isList");
		}
		
		Pattern p = Pattern.compile("\\w+\\.");
		Class date = Date.class;
		Method[] methods = date.getMethods();
		Field[] field = date.getFields();
		for (Method m : methods) {
			System.out.println(p.matcher(m.toString().replaceAll("", "hello")));
		}
		/*
		 * try { Constructor<Date> cons = date.getConstructor(); } catch
		 * (NoSuchMethodException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SecurityException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		
		
	}
}
