package com.learning.test.charpter17;

public class Government implements Generator<String> {
	
	private String[] found = {"beijing","nanjing","chengdu"};
	
	private int index;
	

	//next本身无问题，但是没有考虑到index逐步增大到越界情况，一般配合hasnext()方法使用
	@Override
	public String next() {
		// TODO Auto-generated method stub
		return found[index++];
	}

}
