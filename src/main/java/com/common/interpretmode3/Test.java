package com.common.interpretmode3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		
		Map<String, Integer> operationLevel = new HashMap<String, Integer>();
		operationLevel.put("+", 1);
		operationLevel.put("-", 2);
		operationLevel.put("*", 3);
		operationLevel.put("/", 4);
		String context = "1+2*3/2-5";
		Context c = new Context(context, operationLevel);
		c.execute();
		System.out.println(c.getExpression().interpret());
	}
}
