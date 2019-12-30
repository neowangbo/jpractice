package com.b5wang.jpractice.javase.util;

import java.util.Random;

public class RandomValue {

	public static void main(String[] args) {
		Random random = new Random();

		/**
		 * Random.nextInt(n), the value generated is in [0,n).
		 * */
		for(int i = 1; i <= 100; i++) {
			System.out.println("" + random.nextInt(2));
		}
	}
	
}
