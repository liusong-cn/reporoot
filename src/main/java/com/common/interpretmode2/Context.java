package com.common.interpretmode2;

import java.util.Map;
import java.util.Stack;

public class Context {
	
	private Expression expression;
	
	public void analysis(String expStr){
		char[] str = expStr.toCharArray();
		Expression left = null;
		Expression right = null;
		Stack<Expression> stack = new Stack<Expression>();
		for (int i=0;i<str.length;i++) {
			switch (str[i]) {
			case '+':
				left = stack.pop();
				right = new ValueExpression(String.valueOf(str[++i]));
				stack.push(new AddExpression(left, right));
				break;
				
			case '-':
				left = stack.pop();
				right = new ValueExpression(String.valueOf(str[++i]));
				stack.push(new SubExpression(left, right));
				break;
			default:
				stack.push(new ValueExpression(String.valueOf(str[i])));
				break;
			}
		}
		expression = stack.pop();
		
	}
	
	public int cal(Map<String,Integer> context){
		return expression.interpret(context);
	}
}
