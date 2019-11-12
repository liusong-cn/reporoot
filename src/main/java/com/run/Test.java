package com.run;

import com.common.test.People;
import com.common.util.ApplicationContextUtil;

public class Test {
	
	public static void main(String[] args) {
		//MyRun run = ApplicationContextUtil.getBean("myRun");
		//People p = ApplicationContextUtil.getBean("people");
		//run.run();
		NoAnnotationBean bean = ApplicationContextUtil.getBean("noAnnotationBean");
		bean.sayHello();
	}
}
