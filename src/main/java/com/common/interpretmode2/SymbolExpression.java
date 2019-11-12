package com.common.interpretmode2;

import java.util.Map;

public abstract class SymbolExpression extends Expression {

	protected Expression left;
	
	protected Expression right;
	
	protected SymbolExpression(Expression left, Expression right){
		this.left = left;
		this.right = right;
	}
}
