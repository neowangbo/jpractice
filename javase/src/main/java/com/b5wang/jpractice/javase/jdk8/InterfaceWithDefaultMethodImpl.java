package com.b5wang.jpractice.javase.jdk8;

import java.util.Date;

public class InterfaceWithDefaultMethodImpl implements InterfaceWithDefaultMethod {

	@Override
	public String getDate() {
		Date date = new Date();
		return date.toString();
	}

	public static void main(String[] args) {
		InterfaceWithDefaultMethodImpl obj = new InterfaceWithDefaultMethodImpl();
		
		System.out.println("Date : " + obj.getDate());
		System.out.println("Year : " + obj.getYear());
		System.out.println("Month: " + obj.getMonth());
		System.out.println("Date : " + obj.getDayOfMonth());
	}
}
