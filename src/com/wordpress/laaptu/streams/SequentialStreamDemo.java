package com.wordpress.laaptu.streams;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.wordpress.laaptu.lambda.model.DataHolder;
import com.wordpress.laaptu.lambda.model.Person;
import com.wordpress.laaptu.lambda.model.Person.Sex;

public class SequentialStreamDemo {

	public static void main(String[] args) {
		withoutStream();
		withStream();
	}

	public static void withoutStream() {
		System.out.println("withoutStream()----------");
		ArrayList<Person> personList = getPersonList();
		Predicate<Person> predicate = p -> p.age >= 40;
		personList.forEach(p -> {
			if (predicate.test(p))
				System.out.println(p.toString());
		});
	}

	public static void withStream() {
		System.out.println("withStream()----------");
		ArrayList<Person> personList = getPersonList();
		Predicate<Person> predicateAge = p -> p.age >= 40;
		Predicate<Person> predicateSex = p -> p.sex == Sex.MALE;
		personList.stream().filter(predicateAge).filter(predicateSex).forEach(p -> System.out.println(p.toString()));
		// mapping changing from one stream to other
		// the personList stream is now converted to stream of integer
		System.out.println("converting one stream to other ----------");
		IntPredicate predicateInt = p -> p >= 40;
		personList.stream().mapToInt(p -> p.age).filter(predicateInt).forEach(p -> System.out.println(p * 10));
		System.out.println("adding operation to stream ---------");
		personList.stream().map(p -> new String(p.name + ": Added")).map(String::toUpperCase)
				.forEach(s -> System.out.println(s));
		System.out.println("optionals usage ---------");
		// Optionals are variables which can or can't have a value
		// so before using it one needs to check whether it has a value or not
		OptionalDouble average = personList.stream().mapToInt(p -> p.age).average();
		if (average.isPresent())
			System.out.println("Average = " + average.getAsDouble());
		else
			System.out.println("Average not present");
	}

	public static ArrayList<Person> getPersonList() {
		return new ArrayList<Person>(DataHolder.personList);
	}

}
