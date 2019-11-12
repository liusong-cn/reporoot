package com.common.interpretmode2;

import java.util.Map;

public class ValueExpression extends Expression {
	
	private String key;
	
	public ValueExpression(String key){
		this.key = key;
	}
	
	@Override
	public int interpret(Map<String, Integer> context) {
		return context.get(key);
	}

}
