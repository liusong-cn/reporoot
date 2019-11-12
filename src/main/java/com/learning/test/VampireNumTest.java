package com.learning.test;

import java.util.ArrayList;
import java.util.List;

public class VampireNumTest {
	
	public void getVampireNum() {
		for (int i = 1000; i < 10000; i++) {
			//求各位上的数
			int[] weinum = new int[4];
			weinum[0] = i%10;
			weinum[1] = i/10%10;
			weinum[2] = i/100%10;
			weinum[3] = i/1000%10;
			if(weinum[0] == 0 && weinum[1] == 0) continue;
			for (int j = 10; j < 100; j++) {
				int k;
				if(i%j == 0 && i/j >= 10 && i/j < 100) {
					k = i/j;
					int[] jnum = new int[2];
					jnum[0] = j%10;
					jnum[1] = j/10%10;
					int[] knum = new int[2];
					knum[0] = k%10;
					knum[1]	= k/10%10;
					if(judgeWeiNumMatch(weinum,jnum,knum)) {
						System.out.println(i + "," + j +"," + k);
					}
				}
			}
			
		}
	}
	
	//通过转化为list，设置匹配的数字为null，从而使用一个list就可以判断是否包含
	public boolean judgeWeiNumMatch(int[] scope, int[] one, int[] two) {
		List<String> scopes = transform2List(scope);
		List<String> ones = transform2List(one);
		List<String> twos = transform2List(two);
		for (String oneNum : ones) {
			boolean inside = false;
			for (int i = 0; i < scopes.size(); i++) {
				if(oneNum.equals(scopes.get(i))) {
					scopes.set(i, "null");
					inside = true;
					break;
				}
			}
			if(!inside) return false;
		}
		
		for (String twoNum : twos) {
			boolean inside = false;
			for (int i = 0; i < scopes.size(); i++) {
				if(twoNum.equals(scopes.get(i))) {
					scopes.set(i, "null");
					inside = true;
					break;
				}
			}
			if(!inside) return false;
		}
		return true;
	}
	
	public List<String> transform2List(int[] origin) {
		List<String> list = new ArrayList<String>();
		for (int num : origin) {
			list.add(Integer.toString(num));
		}
		return list;
	}
	
	public static void main(String[] args) {
		VampireNumTest vam = new VampireNumTest();
		vam.getVampireNum();
	}
}
