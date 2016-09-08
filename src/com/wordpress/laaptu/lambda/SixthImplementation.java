package com.wordpress.laaptu.lambda;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Lambda expression for Comparator
 */
public class SixthImplementation {
	static ArrayList<String> names = new ArrayList<String>() {
		{
			add("Z");
			add("A");
			add("E");
			add("C");
			add("Y");
		}
	};

	public static void main(String[] args) {
		withoutLambda();
		withLambda();
	}

	public static void withoutLambda() {
		System.out.println("Without lambda-------");
		ArrayList<String> nameClone = new ArrayList<String>(names);
		Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String name1, String name2) {
				return name1.compareToIgnoreCase(name2);
			}
		};
		nameClone.sort(comparator);
		printNames(nameClone);
	}

	public static void withLambda() {
		System.out.println("With lambda-------");
		ArrayList<String> nameClone = new ArrayList<String>(names);
		nameClone.sort((name1, name2) -> name1.compareToIgnoreCase(name2));
		printNamesWithLambda(nameClone);
	}

	public static void printNames(ArrayList<String> names) {
		for (String name : names)
			System.out.println(name);
	}

	// https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#forEach-java.util.function.Consumer-
	public static void printNamesWithLambda(ArrayList<String> names) {
		/*
		 * This is just like taking one item from list and passing that item to
		 * a function, where one is simply printing the name
		 */
		names.forEach(name -> System.out.println(name));
	}
}
