package com.learning.test;

/**
 * 计算四位数的vampirenumber
 * @author Administrator
 *
 */
public class VampireNum {
	
	//千分位
	public static int a(int i) {
		return i/1000;
	}
	
	//百分位
	public static int b(int i) {
		return i%1000/100;
	}
	//十分位
	public static int c(int i) {
		return i%1000%100/10;
	}
	//个位
	public static int d(int i) {
		return i%1000%100%10;
	}
	
	public static int com(int i, int j) {
		return i*10 + j;
	}
	
	public static void getVampireNum(int i, int j, int k) {
		if(i == j*k) System.out.println(i);
	}
	
	public  static void main(String[] args) {
		for (int i = 1000; i < 10000; i++) {
			//c41*c31*c21/2 吸血鬼数字的排列左右是一样，此种方式需要对排列组合比较熟悉
			VampireNum.getVampireNum(i, com(a(i),b(i)), com(c(i),d(i)));
			VampireNum.getVampireNum(i, com(a(i),c(i)), com(b(i),d(i)));
			VampireNum.getVampireNum(i, com(a(i),b(i)), com(d(i),c(i)));
			VampireNum.getVampireNum(i, com(a(i),c(i)), com(d(i),b(i)));
			VampireNum.getVampireNum(i, com(a(i),d(i)), com(c(i),b(i)));
			VampireNum.getVampireNum(i, com(a(i),d(i)), com(b(i),c(i)));
			VampireNum.getVampireNum(i, com(b(i),a(i)), com(c(i),d(i)));
			VampireNum.getVampireNum(i, com(b(i),a(i)), com(d(i),c(i)));
			VampireNum.getVampireNum(i, com(b(i),c(i)), com(d(i),a(i)));
			VampireNum.getVampireNum(i, com(b(i),d(i)), com(c(i),a(i)));
			VampireNum.getVampireNum(i, com(c(i),a(i)), com(d(i),b(i)));
			VampireNum.getVampireNum(i, com(c(i),b(i)), com(d(i),a(i)));
		}
	}
}
