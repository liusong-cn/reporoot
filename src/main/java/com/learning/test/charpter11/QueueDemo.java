package com.learning.test.charpter11;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
	
	//queue接口定义了先进先出的规则
	Queue<Integer> queue = new LinkedList<Integer>();
	
	Queue<Character> queue1 = new LinkedList<Character>();
	
	//定义了优先级的队列，通过comparator实现排序规则
	PriorityQueue<Character> queue2 = new PriorityQueue<Character>(new Comparator<Character>() {
		
		@Override
		public int compare(Character o1, Character o2) {
			if(o1.charValue() > o2.charValue()) {
				return -1;
			}
			if(o1.charValue() == o2.charValue()) {
				return 0;
			}
			return 1;
		};
	});
	
	//lambda函数版
	PriorityQueue<Character> queue3 = new PriorityQueue<Character>((a,b)-> {if(a > b) {return 1;} if(a<b) {return -1;}return 0;});
	
	Random r = new Random(24);
	
	public void makeIntegerQueue() {
		for (int i = 0; i < 10; i++) {
			queue.offer(r.nextInt(i+10));
			System.out.print(r.nextInt(i+10) + " ");
		}
	}
	
	public void makeCharacterQueue() {
		for (Character c :  "abc".toCharArray()) {
			queue1.offer(c);
		}
	}
	
	public void makePriorityQueue() {
		for (Character c :  "aceb".toCharArray()) {
			queue2.offer(c);
		}
	}
	
	public void makePriorityQueue1() {
		for (Character c :  "aceb".toCharArray()) {
			queue3.offer(c);
		}
	}
	
	public static void main(String[] args) {
		QueueDemo d = new QueueDemo();
		d.makeCharacterQueue();
		d.makeIntegerQueue();
		d.makePriorityQueue();
		d.makePriorityQueue1();
		/*
		 * while (d.queue.peek() != null) { System.out.print(d.queue.remove() + " ");
		 * 
		 * }
		 * 
		 * while (d.queue1.peek() != null) { System.out.print(d.queue1.remove() + " ");
		 * 
		 * }
		 */
		
		while (d.queue2.peek() != null) {
			
			System.out.print(d.queue2.remove() + " ");
			
		}
		while (d.queue3.peek() != null) {
			
			System.out.print(d.queue3.remove() + " ");
			
		}
		
	}
	
}
