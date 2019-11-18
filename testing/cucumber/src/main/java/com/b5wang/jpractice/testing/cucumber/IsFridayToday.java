package com.b5wang.jpractice.testing.cucumber;

public class IsFridayToday {

	public static String today(String date) {
		
		if(date.equalsIgnoreCase("Friday")) {
			return "Yep";
		}else{
			return "Nope";
		}
		
	}
}
