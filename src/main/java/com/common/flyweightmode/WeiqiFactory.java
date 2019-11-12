package com.common.flyweightmode;

import java.util.HashMap;

public class WeiqiFactory {
	
	private HashMap<String, Weiqi> chess;
	
	private static WeiqiFactory instance = new WeiqiFactory();
	
	public WeiqiFactory(){
		chess = new HashMap<String, Weiqi>();
		BlackWeiqi b = new BlackWeiqi("black");
		WhiteWeiqi w = new WhiteWeiqi("white");
		chess.put("black", b);
		chess.put("white", w);
	}
	
	public static WeiqiFactory getInstance(){
		return instance;
	}
	
	public Weiqi getChess(String color){
		return chess.get(color);
	}
}
