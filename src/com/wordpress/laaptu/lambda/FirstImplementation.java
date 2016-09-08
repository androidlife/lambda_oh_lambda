package com.wordpress.laaptu.lambda;

public class FirstImplementation {
	interface IPrint {
		void printName();
	}

	static class Printer {
		public void print(IPrint print) {
			print.printName();
		}
	}

	public static void main(String[] args) {
		System.out.println("*** printNameWithoutParameters *** ");
		Printer printer = new Printer();
		IPrint print;
		print = new IPrint() {

			@Override
			public void printName() {
				System.out.println("Print without lambda");
			}
		};
		print.printName();
		printer.print(() -> System.out.println("Print with lambda"));

		print = () -> {
			System.out.println("First print with lambda");
			System.out.println("Second print with lambda");
		};
		printer.print(print);

	}

}
