package com.common.interpretmode;

public class Command extends Node {
	
	private Node directionNode;
	
	private Node actionNode;
	
	private Node distanceNode;
	
	public Command(Node direcNode, Node actionNode , Node distancNode){
		this.directionNode = direcNode;
		this.actionNode = actionNode;
		this.distanceNode = distancNode;
	}
	
	@Override
	public void interpret() {
		// TODO Auto-generated method stub
		directionNode.interpret();
		actionNode.interpret();
		distanceNode.interpret();
	}

}
