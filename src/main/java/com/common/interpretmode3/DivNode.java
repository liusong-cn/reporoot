package com.common.interpretmode3;

public class DivNode extends Node {
	
	private Node leftNode;
	
	private Node rightNode;
	
	protected DivNode(Node leftNode, Node rightNode){
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	@Override
	protected double interpret() {
		// TODO Auto-generated method stub
		return leftNode.interpret()/rightNode.interpret();
	}

}
