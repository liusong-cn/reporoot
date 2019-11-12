package com.run;

import org.springframework.stereotype.Service;

@Service("myRun")
public class MyRun implements IRun {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("已经跑起来了");
	}

}
