package com.common.interpretmode2;

import java.util.Map;

public abstract class Expression {
	
	public abstract  int interpret(Map<String, Integer> context);
}
