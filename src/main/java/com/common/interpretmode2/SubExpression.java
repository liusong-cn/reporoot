package com.common.interpretmode2;

import java.util.Map;

public class SubExpression extends SymbolExpression {

	protected SubExpression(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int interpret(Map<String, Integer> context) {
		// TODO Auto-generated method stub
		return super.left.interpret(context) - super.right.interpret(context);
	}

}
