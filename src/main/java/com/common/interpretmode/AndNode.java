package com.common.interpretmode;

public class AndNode extends Node {
	
	private Node leftNode;
	
	private Node rightNode;
	
	public AndNode(Node leftNode, Node rightNode){
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	@Override
	public void interpret() {
		// TODO Auto-generated method stub
		leftNode.interpret();
		rightNode.interpret();
	}

}
