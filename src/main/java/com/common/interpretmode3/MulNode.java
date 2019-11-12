package com.common.interpretmode3;

public class MulNode extends Node {
	
	private Node leftNode;
	
	private Node rightNode;
	
	protected MulNode(Node leftNode, Node rightNode){
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	@Override
	protected double interpret() {
		// TODO Auto-generated method stub
		return leftNode.interpret()*rightNode.interpret();
	}

}
