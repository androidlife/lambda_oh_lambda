package com.wordpress.laaptu.lambda;

/**
 * Lambda expression for Runnable with thread
 */
public class FifthImplementation {
	public static void main(String[] args) {
		withoutLambda();
		withLambda();
	}

	public static void withoutLambda() {

		Runnable firstRunnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("Without lambda: This is first run");
			}
		};
		Runnable secondRunnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("Without lambda: This is second run");
			}
		};
		new Thread(firstRunnable).start();
		new Thread(secondRunnable).start();
	}

	public static void withLambda() {
		Runnable firstRunnable = () -> System.out.println("With lambda: This is first run");
		Runnable secondRunnable = () -> {
			System.out.println("With lambda: This is second run");
			System.out.println("With lambda: Run run always run second");
		};
		new Thread(firstRunnable).start();
		new Thread(secondRunnable).start();
	}
}
