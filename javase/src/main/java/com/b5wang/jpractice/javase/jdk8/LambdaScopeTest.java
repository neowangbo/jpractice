package com.b5wang.jpractice.javase.jdk8;

import java.util.function.Consumer;

public class LambdaScopeTest {
	public int x = 0;

	class FirstLevel {

		public int x = 1;

		void methodInFirstLevel(int x) {

			// The following statement causes the compiler to generate
			// the error "local variables referenced from a lambda expression
			// must be final or effectively final" in statement A:
			// x = 99;
			
			int z = 100;
			// z = 200; only access local variables and parameters of the enclosing block that are final or effectively final
			
			Consumer<Integer> myConsumer = (y) -> {
				System.out.println("x = " + x); // Statement A
				System.out.println("y = " + y);
				System.out.println("z = " + z);
				System.out.println("this.x = " + this.x);// access variables in the enclosing class, use the keyword this
				System.out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);
			};

			myConsumer.accept(x);

		}
	}

	public static void main(String... args) {
		LambdaScopeTest st = new LambdaScopeTest();
		LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(23);
	}
}
