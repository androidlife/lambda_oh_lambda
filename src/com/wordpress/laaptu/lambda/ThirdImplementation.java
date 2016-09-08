package com.wordpress.laaptu.lambda;

/**
 * Lambda expression for interface with single argument and no return type
 */

public class ThirdImplementation {
	interface IPrint {
		void printName(String name);
	}

	public static void main(String[] args) {
		IPrint print;
		String printName = "Without lambda";
		print = new IPrint() {

			@Override
			public void printName(String name) {
				System.out.println("Is this your name : " + name);
			}
		};
		print.printName(printName);

		printName = "With lambda";
		print = (s) -> System.out.println(s + " :With single expression only");
		print.printName(printName);

		print = (String s) -> {
			System.out.println("Your string " + s);
			System.out.println("Mine string is empty");
		};
		print.printName(printName);
	}
}
