package com.learning.test.charpter17;

import java.util.PriorityQueue;

public class ToDo extends PriorityQueue<ToDo.ToDoItem> {
	//采用静态内部类的目的是在于隐藏数据对象的实现细节，外部无法访问
	static class ToDoItem implements Comparable<ToDoItem>{
		
		 int primary;
		
		 int second;
		
		 String item;
		
		ToDoItem(int primary, int second, String item){
			this.item = item;
			
			this.primary = primary;
			
			this.second = second;
			
		}

		@Override
		public int compareTo(ToDoItem o) {
			// TODO Auto-generated method stub
			if(primary>o.primary) return 1;
			if(primary == o.primary) {
				return second == o.second?0:(second>o.second?-1:1);
			}
			return -1;
		}
		
		public String toString() {
			return "primary:" + primary + ",second:" + second + ",item:"+ item;
		}
		
	}
	
	public void addToDoItem(int primary, int second, String item) {
		super.add(new ToDoItem(primary, second, item));
	}
	
	
	public static void main(String[] args) {
		ToDo to = new ToDo();
		to.add(new ToDoItem(0, 0, "a"));
		to.add(new ToDoItem(0, 1, "b"));
		to.add(new ToDoItem(1, 0, "c"));
		to.add(new ToDoItem(1, 1, "d"));
		to.add(new ToDoItem(2, 0, "e"));
		to.add(new ToDoItem(2, 1, "f"));
		//可以看到在priorityqueue中，只有队列的第一个元素是经过了优先级设置的，其余元素依然保持着插入的顺序
		System.out.println(to);
		/*
		 * for (int i = 0; i < 6; i++) { System.out.println(to.peek()); to.remove(); }
		 */
		//但是一旦开始出队列，那么就会按照优先级算法来依次出队，而不是按照插入顺序出队
		while(to.peek()!= null) {
			System.out.println(to.remove());
		}
	}
}
