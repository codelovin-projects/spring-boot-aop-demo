package com.codelovin.spring.aopdemo;

public class Car {

	private long id;
	
	private String model;
	private int manufacturingYear;
	
	public Car() {}
	
	public Car(long id, String model, int my) {
		this.id = id;
		this.model = model;
		this.manufacturingYear = my;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getManufacturingYear() {
		return manufacturingYear;
	}
	public void setManufacturingYear(int manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}
	
	
}
