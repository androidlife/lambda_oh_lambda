package com.wordpress.laaptu.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

import com.wordpress.laaptu.lambda.model.Person;
import com.wordpress.laaptu.lambda.model.Person.Sex;

/**
 * Using Predicate with list
 * https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
 */
public class SeventhImplementation {
	static ArrayList<Person> personList = new ArrayList<Person>() {
		{
			add(new Person("Arnold", 67, Sex.MALE));
			add(new Person("Olivia", 25, Sex.FEMALE));
			add(new Person("Tom", 40, Sex.MALE));
			add(new Person("Bill", 35, Sex.MALE));
			add(new Person("Drew", 20, Sex.FEMALE));
			add(new Person("Cameroon", 30, Sex.FEMALE));
			add(new Person("Rocky", 60, Sex.MALE));
		}
	};

	public static void main(String[] args) {
		withoutLambda();
		withLambda();
	}

	public static void withoutLambda() {
		System.out.println("Without Lambda---------");
		Predicate<Person> predicate = new Predicate<Person>() {

			@Override
			public boolean test(Person person) {
				return person.age >= 25 && person.sex == Sex.FEMALE;
			}
		};
		for (Person person : personList) {
			if (predicate.test(person))
				System.out.println(person.name);
		}
	}

	public static void withLambda() {
		System.out.println("With Lambda---------");
		Predicate<Person> predicate = p -> p.age >= 40 && p.sex == Sex.MALE;
		personList.forEach(p -> {
			if (predicate.test(p))
				System.out.println(p.name);
		});
	}

}
