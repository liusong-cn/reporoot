package com.common.combinemode;

public abstract class Company {
	
	public String name;
	
	public Company(String name){
		this.name = name;
	}
	
	abstract void addCompany(Company company);
	
	abstract void removeCompay(Company company);
	
	abstract void display(int depth);
	
	abstract void lineOfDuty();
}
