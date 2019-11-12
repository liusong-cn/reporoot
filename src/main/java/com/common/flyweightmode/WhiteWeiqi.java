package com.common.flyweightmode;

public class WhiteWeiqi extends Weiqi {

	protected WhiteWeiqi(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void display(Coordination c) {
		// TODO Auto-generated method stub
		System.out.println("白棋,颜色是：" + color + "位置是：" + c.getX() + "--" + c.getY());
	}

}
