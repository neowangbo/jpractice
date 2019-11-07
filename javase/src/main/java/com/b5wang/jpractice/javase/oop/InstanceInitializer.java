package com.b5wang.jpractice.javase.oop;

public class InstanceInitializer {

	// instance variable initializer
	String s = "abc";

	// constructor
	public InstanceInitializer() {
			System.out.println("constructor called");
		}

	// static initializer
	static {
		System.out.println("static initializer called");
	}

	// instance initializer
	{
		System.out.println("instance initializer called");
	}

	public static void main(String[] args) {
		new InstanceInitializer();
		new InstanceInitializer();
	}
}
