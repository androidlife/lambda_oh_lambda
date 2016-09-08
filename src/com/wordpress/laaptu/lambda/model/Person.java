package com.wordpress.laaptu.lambda.model;

public class Person implements IPersonInterface {
	public String name;
	public int age;

	public enum Sex {
		MALE, FEMALE
	}

	public Sex sex;

	public Person(String name, int age, Sex sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	// the below method definition match the strucute of Comparator<>,
	// and can be treated for sorting

	public static int compareAgesStatically(Person p1, Person p2) {
		return new Integer(p1.age).compareTo(p2.age);
	}

	@Override
	public String toString() {
		return name + "(" + String.valueOf(age) + ")";
	}

	// the following method implementation, makes this class similar to
	// implements IPersonInterface
	// though age and name are public, this is just for test
	// so when we do this, it will now refer to IPersonInterface as well
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

}
