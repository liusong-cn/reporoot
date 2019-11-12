package com.common.commandmode;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	
	private List<Command> list = new ArrayList<Command>();
	
	public void addCommand(Command c){
		list.add(c);
	}
	
	public void deprecateCommand(Command c){
		list.remove(c);
	}
	
	public void executeAllCommand(){
		for (Command command : list) {
			command.execute();
		}
	}
}
