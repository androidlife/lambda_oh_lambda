package com.wordpress.laaptu.lambda.model;

import java.util.ArrayList;

import com.wordpress.laaptu.lambda.model.Person.Sex;

public class DataHolder {
	public static ArrayList<Person> personList = new ArrayList<Person>() {
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
}
