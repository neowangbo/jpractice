package com.b5wang.jpractice.javase.oop.anonymousclass;

/*
 * While local classes are class declarations, anonymous classes are expressions, 
 * which means that you define the class in another expression.
 * */
public class HelloAnonymousClass {

	private static final String NAME = "test_";
	
	private int no = 1;

	public void sayHello() {
		
		String localStr = "";
		int tmpInt = 1000;
		
		Hello englishHello = new EnglishHello();

		Hello frenchHello = new Hello() {
			
			@Override
			public void greet() {
				greetSomeone("tout le monde");
			}

			@Override
			public void greetSomeone(String someone) {
				String tmpStr = NAME + no + tmpInt;
				System.out.println("Salut " + someone + "!" + tmpStr);
			}
			
		};

		Hello spanishHello = new Hello() {

			@Override
			public void greet() {
				greetSomeone("mundo");
			}

			@Override
			public void greetSomeone(String someone) {
				System.out.println("Hola, " + someone + "!");
			}

		};

		englishHello.greet();
		frenchHello.greet();
		spanishHello.greet();

		englishHello.greetSomeone("Tom");
		frenchHello.greetSomeone("Jerry");
		spanishHello.greetSomeone("Neo");
	}

	public static void main(String... args) {
		HelloAnonymousClass hac = new HelloAnonymousClass();
		hac.sayHello();
	}

}
