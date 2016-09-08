package com.wordpress.laaptu.methodreference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

import com.wordpress.laaptu.lambda.model.DataHolder;
import com.wordpress.laaptu.lambda.model.Person;

public class CompareAges {
	public static void main(String[] args) {
		staticMethodReference();
		new CompareAges().instanceMethodReference();
		defaultInterface();
	}

	public static void staticMethodReference() {
		System.out.println("staticMethodReference----------");
		ArrayList<Person> personClone = new ArrayList<>(DataHolder.personList);
		Collections.sort(personClone, Person::compareAgesStatically);
		personClone.forEach(p -> System.out.println(p.toString()));
	}

	public static void defaultInterface() {
		/**
		 * Since Person has methods like getName(), getAge() i.e. exact method
		 * signature() and implementation(), it can be treated as instane of
		 * IPersonInterface
		 */
		System.out.println("defaultInterface----------");
		Predicate<Person> predicate = p -> p.age >= 35;
		ArrayList<Person> personClone = new ArrayList<>(DataHolder.personList);
		personClone.forEach(p -> {
			if (predicate.test(p))
				System.out.println(p.printNameNAge());
		});

	}

	public void instanceMethodReference() {
		System.out.println("instanceMethodReference--------");
		ArrayList<Person> personClone = new ArrayList<>(DataHolder.personList);
		Collections.sort(personClone, this::compareAgesByInstanceMethod);
		personClone.forEach(p -> System.out.println(p.toString()));
	}

	private int compareAgesByInstanceMethod(Person p1, Person p2) {
		return new Integer(p1.age).compareTo(p2.age);
	}

}
