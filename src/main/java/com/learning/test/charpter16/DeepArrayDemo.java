package com.learning.test.charpter16;

import java.util.Arrays;

public class DeepArrayDemo {
	public static void main(String[] args) {
		//多维数组的定义：
		//eg：二维数组表示数组的数组，二维数组的每一个元素都是一个一维数组
		//以 a = new int[一维数组的个数][一维数组的长度]
		//所以在打印a = new int[2][3]时会看到[[0, 0, 0], [0, 0, 0]]
		int[][] a = new int[2][3];
		System.out.println(Arrays.deepToString(a));
		
		int[][] b = new int[][]{{1,2},{0},{1,3}};
		System.out.println(Arrays.deepToString(b));
		
		int[][] c = new int[3][5];
		System.out.println(Arrays.deepToString(c));
		
		//更高维度的数组则依次递减
		//eg：三维数组表示二维数组的数组，其中二维数组又可以拆解为一维数组的数组
		//故下方的d表示有2个二维数组，其中二维数组拆解为3个长度为4的一维数组
		int[][][] d = new int[2][3][4];
		System.out.println(Arrays.deepToString(d));
		
	}
}
