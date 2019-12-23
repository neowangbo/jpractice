package com.b5wang.jpractice.javase.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	String name;

	int age;

	Sex gender;

	public Person(String name, int age, Sex gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public Sex getGender() {
		return gender;
	}

	public void printPerson() {
		System.out.println("Name: " + name + ". age = " + age);
	}

	/*
	 * Approach 1: Create Methods That Search for Members That Match One
	 * Characteristic
	 */
	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}

	/*
	 * Approach 2: Create More Generalized Search Methods
	 */
	public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
		for (Person p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				p.printPerson();
			}
		}
	}

	// ---------------------------------------------------------------------------------------
	/*
	 * Approach 3: Specify Search Criteria Code in a Local Class
	 */
	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	interface CheckPerson {
		boolean test(Person p);
	}

	static class CheckPersonEligibleForSelectiveService implements CheckPerson {
		public boolean test(Person p) {
			return p.gender == Person.Sex.MALE && p.getAge() >= 30 && p.getAge() <= 45;
		}
	}
	// ---------------------------------------------------------------------------------------

	// Approach 6: Use Standard Functional Interfaces with Lambda Expressions
	public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	// ========================================================================================
	// Approach 7: Use Lambda Expressions Throughout Your Application
	public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				block.accept(p);
			}
		}
	}
	
	// Do more
	public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester,
			Function<Person, String> mapper, Consumer<String> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
	// ========================================================================================

	// Approach 8: Use Generics More Extensively
	public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> block) {
		for (X p : source) {
			if (tester.test(p)) {
				Y data = mapper.apply(p);
				block.accept(data);
			}
		}
	}
	
	
	public static void main(String[] args) {

		List<Person> roster = new ArrayList<>();
		roster.add(new Person("Jerry", 14, Sex.MALE));
		roster.add(new Person("Tom", 16, Sex.MALE));
		roster.add(new Person("Tony", 26, Sex.MALE));
		roster.add(new Person("Peter", 38, Sex.MALE));
		roster.add(new Person("Patrick", 42, Sex.MALE));
		roster.add(new Person("Marry", 59, Sex.FEMALE));
		roster.add(new Person("Rose", 68, Sex.FEMALE));
		roster.add(new Person("Cathine", 98, Sex.FEMALE));

		// Approach 1
		printPersonsOlderThan(roster, 30);
		System.out.println("---------------------------- Approach 1");

		// Approach 2
		printPersonsWithinAgeRange(roster, 10, 20);
		System.out.println("---------------------------- Approach 2");

		// Approach 3
		printPersons(roster, new CheckPersonEligibleForSelectiveService());
		System.out.println("---------------------------- Approach 3");

		// Approach 4: Specify Search Criteria Code in an Anonymous Class
		printPersons(roster, new CheckPerson() {
			@Override
			public boolean test(Person p) {
				return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35;
			}
		});
		System.out.println("---------------------------- Approach 4");

		// Approach 5: Specify Search Criteria Code with a Lambda Expression
		// Anonymous method? (param) -> what need to return
		printPersons(roster, (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35);
		System.out.println("---------------------------- Approach 5");

		// Approach 6
		printPersonsWithPredicate(roster,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35);
		System.out.println("---------------------------- Approach 6");

		// Approach 7
		processPersons(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35,
				p -> p.printPerson());
		System.out.println("---------------------------- Approach 7");
		
		processPersonsWithFunction(roster,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35, 
				p -> p.getName(),
				name -> System.out.println(name));
		System.out.println("---------------------------- More than Approach 7");
		
		processElements(roster,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35, 
				p -> p.getName(),
				name -> System.out.println(name));
		System.out.println("---------------------------- Approach 8");

		
		// Approach 9: Use Aggregate Operations That Accept Lambda Expressions as Parameters
		roster.stream()
			.filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35)
				.map(p -> p.getName()).forEach(name -> System.out.println(name));
		System.out.println("---------------------------- Approach 9");

	}
}
