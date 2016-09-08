package com.wordpress.laaptu.lambda;

public class SecondImplementation {
	interface IPrint {
		String printName();
	}

	static class Printer {
		void print(IPrint print) {
			String printedValue = print.printName();
			System.out.println("The printedValue = " + printedValue);
			System.out.println("**********");
		}
	}

	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.print(new IPrint() {

			@Override
			public String printName() {
				String value = "Without lambda";
				System.out.println(value + " -------------");
				return value;
			}
		});

		printer.print(() -> "With lambda");
		printer.print(() -> {
			String value = "With lambda again";
			System.out.println(value + " -------");
			return value;
		});
	}
}
