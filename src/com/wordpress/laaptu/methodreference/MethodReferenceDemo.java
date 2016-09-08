package com.wordpress.laaptu.methodreference;

/**
 * What is happening here if any function ,() method signature,{} method
 * implementation match the structure of interface, then it can be treated as
 * interface object ICombine, (int age, String name) If some class has to
 * implement that it would be like combine(int age,String name) {
 * //implementation } Adder class has the same method signature and method
 * implementation in addArguments(int a,String b){ } so this can be treated as
 * interface object or implementation
 * that's why it can be passed to doCombine(), as it has the same method signature
 * and implementation as of interface ICombine implementation
 */
public class MethodReferenceDemo {
	interface ICombine {
		void combine(int age, String name);
	}

	public static void main(String[] args) {
		doCombine(Adder::addArguments);
	}

	static class Adder {
		public static void addArguments(int a, String b) {
			System.out.println("addArguments-------");
			String value = String.valueOf(a).concat("::").concat(b);
			System.out.println(value);
		}
	}

	public static void doCombine(ICombine combine) {
		combine.combine(20, "Hello");
	}
}
