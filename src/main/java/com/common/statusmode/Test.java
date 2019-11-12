package com.common.statusmode;

public class Test {
	
	public static void main(String[] args) {
		Vote vote = new Vote();
		for(int i = 0;i < 6;i ++){
			vote.vote("wang", "tongyi");
		}
	}
}
