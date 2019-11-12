package com.learning.test.charpter15;

/**
 * 外部类声明了泛型参数T用于接受不确定类型的参数，
 * 该类是另外一种内部链式存储机制的实现
 * @author Administrator
 *
 * @param <T>
 */
public class LinkedStack<T> {
	//此处内部类的参数类型用泛型U表示,用U来表示和外部类的参数类型的区别
	//试过和外部类参数类型用同一个参数类型T表示，其实一样
	private static class Node<U>{
		U item;
		Node<U> next;
		Node(){item = null;next = null;}
		
		Node(U item, Node<U> next){
			this.item = item;
			this.next = next;
		}
		
		boolean end() {
			return next == null && item == null;
		}
	}
	//在创建类的时候默认生成一个空的node，通过这个空node可以判断是否已经到达栈底
	//这个空node的专业术语 end sentinel:末端哨兵
	private Node<T> top = new Node<T>();
	
	//每一次push都会将新的node链接至原有的node，同时指向最新的node，这种行为就像是向栈顶添加了一个元素
	public void push(T item) {
		top = new Node<T>(item, top);
	}
	
	public T pop() {
		T result = top.item;
		if(!top.end()) top = top.next;
		return result;
	}
	
	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<String>();
		for (String string : "hello world".split(" ")) {
			lss.push(string);
		}
		String s;
		while ((s = lss.pop()) != null) {
			System.out.println(s);
			
		}
		
	}
	
}
