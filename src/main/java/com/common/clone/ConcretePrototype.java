package com.common.clone;

import java.util.List;

public class ConcretePrototype implements Cloneable {
	
	private String name;
	
	private List<String> names;

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ConcretePrototype clone(){
		Object o = null;
		ConcretePrototype c = null;
		try {
			o = super.clone();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (ConcretePrototype)o;
	}
	
}
