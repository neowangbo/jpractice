package com.b5wang.jpractice.javase.jdk8.lambda;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Person {

	private final static String pattern = "yyyy-MM-dd HH:mm:ss";
	private final static SimpleDateFormat FORMATOR = new SimpleDateFormat(pattern);

	public enum Sex {
		MALE, FEMALE
	}

	String name;

	int age;

	Sex gender;

	Date birthday;

	public Person(){}

	public Person(String name, int age, Sex gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 0 - age);
		this.birthday = cal.getTime();

		System.out.println("Create a person: name=" + name + ", age=" + age + ",birthday=" + FORMATOR.format(birthday));
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

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getBirthday() {
		return birthday;
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

	// Method reference
	public static int compareByAge(Person a, Person b){
		return a.birthday.compareTo(b.getBirthday());
	}


	// Reference to a constructor
	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(
			SOURCE sourceCollection,
			Supplier<DEST> collectionFactory) {

		DEST result = collectionFactory.get();
		for (T t : sourceCollection) {
			result.add(t);
		}
		return result;
	}

	public static void main(String[] args) {

		List<Person> roster = new ArrayList<>();
		roster.add(new Person("Patrick", 42, Sex.MALE));
		roster.add(new Person("Tom", 16, Sex.MALE));
		roster.add(new Person("Cathine", 98, Sex.FEMALE));
		roster.add(new Person("Marry", 59, Sex.FEMALE));
		roster.add(new Person("Jerry", 14, Sex.MALE));
		roster.add(new Person("Rose", 68, Sex.FEMALE));
		roster.add(new Person("Tony", 26, Sex.MALE));
		roster.add(new Person("Peter", 38, Sex.MALE));


		System.out.println("---------------------------- Approach 1");
		// Approach 1
		printPersonsOlderThan(roster, 30);


		System.out.println("---------------------------- Approach 2");
		// Approach 2
		printPersonsWithinAgeRange(roster, 10, 20);


		System.out.println("---------------------------- Approach 3");
		// Approach 3
		printPersons(roster, new CheckPersonEligibleForSelectiveService());


		System.out.println("---------------------------- Approach 4");
		// Approach 4: Specify Search Criteria Code in an Anonymous Class
		printPersons(roster, new CheckPerson() {
			@Override
			public boolean test(Person p) {
				return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35;
			}
		});


		System.out.println("---------------------------- Approach 5");
		// Approach 5: Specify Search Criteria Code with a Lambda Expression
		// Anonymous method? (param) -> what need to return
		printPersons(roster, (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35);


		System.out.println("---------------------------- Approach 6");
		// Approach 6
		printPersonsWithPredicate(roster,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35);


		System.out.println("---------------------------- Approach 7");
		// Approach 7
		processPersons(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35,
				p -> p.printPerson());


		System.out.println("---------------------------- More than Approach 7");
		processPersonsWithFunction(roster,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35, 
				p -> p.getName(),
				name -> System.out.println(name));


		System.out.println("---------------------------- Approach 8");
		processElements(roster,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35, 
				p -> p.getName(),
				name -> System.out.println(name));


		System.out.println("---------------------------- Approach 9");
		// Approach 9: Use Aggregate Operations That Accept Lambda Expressions as Parameters
		roster.stream()
			.filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 35)
				.map(p -> p.getName()).forEach(name -> System.out.println(name));


		System.out.println("---------------------------- Method reference");
		// Method reference
		// Sort the roster list
		Person[] rosterArr = roster.toArray(new Person[roster.size()]);
		System.out.println(" === Print all persons:");
		for(Person p : roster){
			p.printPerson();
		}

		// 1 - class implementation
		class PersonAgeComparator implements Comparator<Person> {
			public int compare(Person a, Person b) {
				return a.getBirthday().compareTo(b.getBirthday());
			}
		}
		// Arrays.sort(rosterArr, new PersonAgeComparator());

		// 2 - interface Comparator is a functional interface, so can use lambda expression
		Arrays.sort(rosterArr, (Person a, Person b) -> {
			return a.getBirthday().compareTo(b.getBirthday());
		});

		// 3 - simplify again, uses static method compareByAge in Person.
		Arrays.sort(rosterArr, (Person a, Person b) -> {
			return Person.compareByAge(a, b);
		});
		// or
		Arrays.sort(rosterArr, (a, b) -> Person.compareByAge(a, b));
		// Finally, method reference come out, simplify the method call
		// Reference to a static method
		Arrays.sort(rosterArr, Person::compareByAge);

		System.out.println(" === Print all persons after sorting by birthday:");
		for(Person p : rosterArr){
			p.printPerson();
		}

		// Reference to an instance method of a particular object
		// Sorting by name
		class ComparisonProvider {
			public int compareByName(Person a, Person b) {
				return a.getName().compareTo(b.getName());
			}

			public int compareByAge(Person a, Person b) {
				return a.getBirthday().compareTo(b.getBirthday());
			}
		}

		ComparisonProvider myComparisonProvider = new ComparisonProvider();
		Arrays.sort(rosterArr, myComparisonProvider::compareByName);
		System.out.println(" === Print all persons after sorting by name:");
		for(Person p : rosterArr){
			p.printPerson();
		}

		// Reference to an Instance Method of an Arbitrary Object of a Particular Type
		String[] stringArray = { "Barbara", "James", "Mary", "John",
				"Patricia", "Robert", "Michael", "Linda" };
		System.out.println();
		System.out.println(" --- stringArray             : " + Arrays.toString(stringArray));
		/**
		 * compareToIgnoreCase is an instance method, not a static method
		 * The program knows that it can invoke this method on an instance of String,
		 * so it can take the reference and any object of that type and be guaranteed the method exists.
		 * */
		Arrays.sort(stringArray, String::compareToIgnoreCase);
		System.out.println(" --- stringArray after sorted: " + Arrays.toString(stringArray));

		//Set<Person> rosterSet = transferElements(roster, HashSet<Person>::new);
	}
}
