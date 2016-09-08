package com.wordpress.laaptu.lambda;

import java.util.function.Predicate;

import com.wordpress.laaptu.lambda.model.DataHolder;
import com.wordpress.laaptu.lambda.model.Person;
import com.wordpress.laaptu.lambda.model.Person.Sex;

/**
 * Using Predicate with list
 * https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
 */
public class SeventhImplementation {

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
		for (Person person : DataHolder.personList) {
			if (predicate.test(person))
				System.out.println(person.name);
		}
	}

	public static void withLambda() {
		System.out.println("With Lambda---------");
		Predicate<Person> predicate = p -> p.age >= 40 && p.sex == Sex.MALE;
		DataHolder.personList.forEach(p -> {
			if (predicate.test(p))
				System.out.println(p.name);
		});

	}

}
