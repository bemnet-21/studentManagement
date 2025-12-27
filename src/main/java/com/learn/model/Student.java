package com.learn.model;

public class Student {
	private int id;
	private String name;
	private String email;
	private int year;
	
	public Student() {}
	
	public Student(String name, String email, int year) {
		this.name = name;
		this.email = email;
		this.year = year;
	}
	
	public String getName() { 
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
	
