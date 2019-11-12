package com.learning.test.charpter17;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
	
	public <T> void test(Queue<T> queue, Generator<T> gen) {
		for (int i = 0; i < 10; i++) {
			queue.add(gen.next());
		}
		while (queue.peek() != null) {
			System.out.print(queue.remove() +",");
		}
	}
	
	public static void main(String[] args) {
		QueueDemo q = new QueueDemo();
		q.test(new LinkedList<String>(), new Gen());
		System.out.println("_____________");
		q.test(new PriorityQueue<String>(), new Gen());
	}
}

class Gen implements Generator<String>{
	
	private String[] s = {"hello","world","today","good","have fun"};

	private int index;
	
	@Override
	public String next() {
		// TODO Auto-generated method stub
		return  s[index++>3?new Random().nextInt(4):index];
	}
	
}
