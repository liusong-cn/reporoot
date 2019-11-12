package com.common.statusmode;

import java.util.HashMap;
import java.util.Map;

public class Vote {
	
	private Map<String,String> voteMap = new HashMap<String, String>();
	
	private Map<String,Integer> voteCountMap = new HashMap<String, Integer>();
	
	private Status s;
	
	public void vote(String user, String voteItem){
		Integer count = voteCountMap.get(user);
		count = count==null?0:count;
		if(count >= 5){
			voteMap.remove(user);
			s = new BlackStatus();
		}else if(count>=1){
			voteCountMap.put(user, ++count);
			s = new RepeatStatus();
		}else if(count == 0){
			voteMap.put(user,voteItem);
			voteCountMap.put(user, 1);
			s = new NormalStatus();
		}
		s.vote();
	}
}
