package com.common.flyweightmode;

public class Test {
	
	public static void main(String[] args) {
		BlackWeiqi b1 = (BlackWeiqi) WeiqiFactory.getInstance().getChess("black");
		BlackWeiqi b2 = (BlackWeiqi) WeiqiFactory.getInstance().getChess("black");
		BlackWeiqi b3 = (BlackWeiqi) WeiqiFactory.getInstance().getChess("black");
		System.out.println(b1 == b2 && b1 == b3);
		WhiteWeiqi w1 = (WhiteWeiqi) WeiqiFactory.getInstance().getChess("white");
		WhiteWeiqi w2 = (WhiteWeiqi) WeiqiFactory.getInstance().getChess("white");
		
		b1.display(new Coordination(1,2));
		b2.display(new Coordination(1, 3));
		b3.display(new Coordination(1, 4));
		w1.display(new Coordination(2, 1));
		w2.display(new Coordination(2, 2));
		//享元模式结合了单例模式和工厂模式，由工厂管理和创建类实例，单例模式保证同种只有一个，外部状态传入后时每个实例的表现不一样
	}
}