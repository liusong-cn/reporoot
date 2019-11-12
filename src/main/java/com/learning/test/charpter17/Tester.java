package com.learning.test.charpter17;

import java.util.List;

public class Tester<C> {
	public static int fieldWidth = 8;
	
	public static TestParam[] defaultParams = TestParam.array(10,5000,100,5000,300,600,2000,1000);
	
	protected C initialize(int size) {
		return container;
	}
	
	protected C container;
	
	private String headline = "";
	
	private List<Test<C>> tests;
	
	private static String stringField() {
		return "%" + fieldWidth + "s";
	}
	
	private static String numberField() {
		return "%" + fieldWidth + "d";
	}
	
	private static int sizeWidth = 5;
	
	private static String sizeField = "%" +sizeWidth + "s";
	
	private TestParam[] paramList = defaultParams;
	
	public Tester(C container, List<Test<C>> tests) {
		this.container = container;
		this.tests = tests;
		if(container != null) headline = container.getClass().getSimpleName();
	}
	
	public Tester(C container, List<Test<C>> test, TestParam[] paramList) {
		this(container, test);
		this.paramList = paramList;
	}
	
	public void setHeadline(String newHeadline) {
		headline = newHeadline;
	}
	
	public static <C> void run(C cn,List<Test<C>> tests) {
		new Tester<C>(cn, tests);
	}
	
	public void timeTest() {
		displayHeader();
		for (TestParam param : paramList) {
			System.out.format(sizeField, param.size);
			for (Test<C> test : tests) {
				C container = initialize(param.size);
				long start = System.nanoTime();
				int reps = test.test(container, param);
				long duration = System.nanoTime()  - start;
				long timePerRep = duration/reps;
				System.out.format(numberField(),timePerRep);
			}
		}
	}
	
	public void displayHeader() {
		int width = fieldWidth*tests.size() + sizeWidth;
		int dashLength = width - headline.length() - 1;
		StringBuilder head = new StringBuilder(width);
		for (int i = 0; i < dashLength/2; i++) {
			head.append('-');
		}
		head.append(' ');
		head.append(headline);
		head.append(' ');
		for (int i = 0; i < dashLength; i++) head.append('-');
		System.out.println(head);
		System.out.format(sizeField, "size");
		for (Test<C> testParam : tests) {
			System.out.format(stringField(), testParam.name);	
		}
		System.out.println();
		
	}
	
	
	
}
