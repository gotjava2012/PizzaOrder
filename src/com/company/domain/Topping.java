package com.company.domain;

public enum Topping 
{
		
	CHEESE(1),
	SAUSAGE(2),
	MUSHROOM(3),
	PINEAPPLE(4),
	HAM(5),
	JALAPENO(6),
	PEPPERONI(7);
	
	private int value;
	 
	private Topping(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

