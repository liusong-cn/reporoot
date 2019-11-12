package com.common.flyweightmode;

public class BlackWeiqi extends Weiqi {

	protected BlackWeiqi(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void display(Coordination c) {
		// TODO Auto-generated method stub
		System.out.println("黑棋,颜色是：" + color + "位置是：" + c.getX() + "--" + c.getY());
	}

}
