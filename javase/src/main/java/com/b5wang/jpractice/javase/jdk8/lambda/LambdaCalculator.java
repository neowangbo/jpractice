package com.b5wang.jpractice.javase.jdk8.lambda;

public class LambdaCalculator {
	
	/**
	 * A functional interface, has only one method.
	 * */
	interface IntegerMath {
		int operation(int a, int b);
	}

	public int operateBinary(int a, int b, IntegerMath op) {
		return op.operation(a, b);
	}

	public static void main(String... args) {

		LambdaCalculator myApp = new LambdaCalculator();
		
		// 2ways to implement
		IntegerMath addition = (a, b) -> a + b;
		IntegerMath subtraction = (a, b) -> {
			//The data type that these methods expect is called the target type.
			return a - b;
			};
		System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
		System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, subtraction));
	}
}
