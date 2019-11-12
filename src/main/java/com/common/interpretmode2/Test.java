package com.common.interpretmode2;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
		String exp = "a+b-c+d";
		Map<String, Integer> context = new HashMap<String, Integer>();
		context.put("a", 1);
		context.put("b", 2);
		context.put("c", 2);
		context.put("d", 4);
		
		Context c = new Context();
		c.analysis(exp);
		System.out.println(c.cal(context));
	}
}
