package com.fitness.effit.database.dto;

public class Food {

	private long id;
	private String name;
	private int calories;
	private String servingSize;
	
	public Food() {}
	
	public Food(long id, String name, int calories, String servingSize) {
		this.id = id;
		this.name = name;
		this.calories = calories;
		this.servingSize = servingSize;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getServingSize() {
		return servingSize;
	}
	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}
	
	
	
}
