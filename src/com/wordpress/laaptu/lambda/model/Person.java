package com.wordpress.laaptu.lambda.model;

public class Person {
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

}
