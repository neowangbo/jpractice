package com.b5wang.jpractice.javase.util;

import java.util.Random;

public class RandomValue {

	public static void main(String[] args) {
		Random random = new Random();
		for(int i = 1; i <= 100; i++) {
			System.out.println("" + random.nextInt(5));
		}
	}
	
}
