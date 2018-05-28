package com.martian.apps.javabasics.jdk8;

import java.util.Calendar;

public interface InterfaceWithDefaultMethod {
	
	String[] MONTH_NAMES = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	
	String getDate();
	
	default String getYear() {
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.get(Calendar.YEAR));
	}
	
	default String getMonth() {
		Calendar cal = Calendar.getInstance();
		int index = cal.get(Calendar.MONTH);
		return MONTH_NAMES[index];
	}
	
	default String getDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
	}
}
