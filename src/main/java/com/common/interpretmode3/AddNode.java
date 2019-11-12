package com.common.interpretmode3;

public class AddNode extends Node {
	
	private Node leftNode;
	
	private Node rightNode;
	
	protected AddNode(Node leftNode, Node rightNode){
		this.leftNode  = leftNode;
		this.rightNode = rightNode;
	}
	
	@Override
	protected double interpret() {
		// TODO Auto-generated method stub
		return leftNode.interpret() + rightNode.interpret();
	}

}
