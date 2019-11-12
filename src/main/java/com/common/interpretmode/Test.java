package com.common.interpretmode;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		String context = "up run 2 and right jump 3";
		String[] words = context.split(" ");
		DistanceNode distance = null;
		DirectionNode direction= null;
		ActionNode action = null;
		Command command = null;
		AndNode andNode =null;
		List<Node> nodeList = new ArrayList<Node>();
		for (int i = 0; i < words.length; i++) {
			if(i == 0){
				direction = new DirectionNode(words[i]);
				action = new ActionNode(words[++i]);
				distance = new DistanceNode(words[++i]);
			}else {
				if(words[i].equals("and")){
					direction = new DirectionNode(words[++i]);
					action = new ActionNode(words[++i]);
					distance = new DistanceNode(words[++i]);
				}
			}
			command = new Command(direction, action, distance);
			nodeList.add(command);
			command.interpret();
		}
	}
}
