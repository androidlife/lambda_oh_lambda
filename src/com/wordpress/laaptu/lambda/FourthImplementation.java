package com.wordpress.laaptu.lambda;

/**
 * Lambda expression for interface with two arguments and a return type
 */
public class FourthImplementation {
	interface IPrint {
		int printName(int age, String name);
	}

	public static void main(String[] args) {
		IPrint print;
		print = new IPrint() {

			@Override
			public int printName(int age, String name) {
				System.out.println("Without lambda--------");
				System.out.println("Your name = " + name);
				System.out.println("Your age = " + age);
				return age * 10;
			}
		};
		print.printName(10, "Hello");

		print = (a, b) -> {
			System.out.println("With lambda--------");
			System.out.println("Your name = " + b);
			System.out.println("Your age = " + a);
			return a * 20;
		};
		print.printName(20, "World");

		print = (int age, String name) -> {
			System.out.println("With lambda again --------");
			System.out.println("Your name String value = " + name);
			System.out.println("Your age int value = " + age);
			return age * 30;
		};
		print.printName(30, "Terminator");
	}

}
