package com.learning.test.charpter16;

public class Coffee {
	
	private String taste;
	
	private String name;

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

class BlackCoffee extends Coffee{
	
	private String smell;

	public String getSmell() {
		return smell;
	}

	public void setSmell(String smell) {
		this.smell = smell;
	}
	
	
}

class ItalianCoffee extends Coffee{
	
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
