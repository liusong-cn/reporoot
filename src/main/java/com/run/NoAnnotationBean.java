package com.run;

public class NoAnnotationBean {
	
	private String name;
	
	private String title;

	public NoAnnotationBean(String name, String title) {
		super();
		this.name = name;
		this.title = title;
	}
	
	public NoAnnotationBean(){}
	
	public void sayHello(){
		System.out.println("hello");
	}
	
}
