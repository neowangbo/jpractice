package com.b5wang.jpractice.javase.oop.anonymousclass;

public class EnglishHello implements Hello {

	@Override
	public void greet() {
		System.out.println("Hello!");
	}

	@Override
	public void greetSomeone(String someone) {
		System.out.println("Hello, " + someone + "!");
	}

}
