package com.b5wang.jpractice.testing.cucumber;

public class Employee {
	
	private String ic;
	
	private String name;
	
	/*
	 * F - Female
	 * M - Male
	 * */
	private String gender;//F or M
	
	private int age;
	
	private boolean married;
	
	public String getIc() {
		return ic;
	}

	public void setIc(String ic) {
		this.ic = ic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public boolean isFitEmployee() {
		if((age >= 30 && age <= 45) && gender.equalsIgnoreCase("M")) {
			return true;
		}else {
			return false;
		}
	}

	public boolean isLeader() {
		if(this.isFitEmployee() && this.isMarried()) {
			return true;
		}else {
			return false;
		}
	}
	
}
