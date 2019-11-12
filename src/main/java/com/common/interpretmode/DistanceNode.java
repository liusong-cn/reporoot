package com.common.interpretmode;

public class DistanceNode extends Node {
	
	private String distance;
	
	public DistanceNode(String distance){
		this.distance = distance;
	}
	
	@Override
	public void interpret() {
		// TODO Auto-generated method stub
		
		try {
			Integer in = Integer.parseInt(distance);
			System.out.println(in);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("距离参数不合法");
		}
	}

}
