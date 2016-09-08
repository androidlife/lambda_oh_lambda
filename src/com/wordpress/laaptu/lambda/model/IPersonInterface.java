package com.wordpress.laaptu.lambda.model;

public interface IPersonInterface {
	String getName();

	int getAge();

	default String printNameNAge() {
		return getName() + "( " + getAge() + " ) ";
	}

}
