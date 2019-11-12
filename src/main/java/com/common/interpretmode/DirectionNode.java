package com.common.interpretmode;

public class DirectionNode extends Node {
	
	private String direction;
	
	public DirectionNode(String direction){
		this.direction = direction;
	}
	@Override
	public void interpret() {
		// TODO Auto-generated method stub
		switch (direction) {
		case "up":
			System.out.println("向上");
			break;
		case "down":
			System.out.println("向下");
			break;
		case "left":
			System.out.println("向左");
			break;
		case "right":
			System.out.println("向右");
			break;

		default:
			System.out.println("方向参数不合法");
			break;
		}
	}
	
}
