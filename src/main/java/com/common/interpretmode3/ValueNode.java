package com.common.interpretmode3;

public class ValueNode extends Node {
	
	private String value;
	
	protected ValueNode(String value){
		this.value = value;
	}
	
	@Override
	protected double interpret() {
		// TODO Auto-generated method stub
		return Double.valueOf(value);
	}

}
