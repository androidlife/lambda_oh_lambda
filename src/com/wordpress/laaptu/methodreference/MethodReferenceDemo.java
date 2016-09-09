package com.wordpress.laaptu.methodreference;

/**
 * What is happening here if any function ,() method signature,{} method
 * implementation match the structure of interface, then it can be treated as
 * interface object ICombine, (int age, String name) If some class has to
 * implement that it would be like combine(int age,String name) {
 * //implementation } Adder class has the same method signature and method
 * implementation in addArguments(int a,String b){ } so this can be treated as
 * interface object or implementation that's why it can be passed to
 * doCombine(), as it has the same method signature and implementation as of
 * interface ICombine implementation
 */
public class MethodReferenceDemo {
	interface ICombine {
		void combine(int age, String name);
	}

	public static void main(String[] args) {
		doCombine(Adder::addArguments);

		MethodReferenceDemo demo = new MethodReferenceDemo();
		ICombine combine;
		// without method reference
		combine = new ICombine() {
			@Override
			public void combine(int age, String name) {
				System.out.println("without method reference---------");
				String value = name.concat(" age = ").concat(String.valueOf(age));
				System.out.println("combined value :: " + value);
			}
		};
		combine.combine(40, "Middle age guy");
		// with method reference
		System.out.println("with method reference-----------");
		combine = demo::methodReferenceInstance;
		combine.combine(100, "Old Guy");
		combine = MethodReferenceDemo::methodReferenceStatic;
		combine.combine(25, "Young Guy");
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

	public void methodReferenceInstance(int age, String someName) {
		System.out.println("methodReferenceInstance -----");
		String value = someName.concat(" age = ").concat(String.valueOf(age));
		System.out.println("combined value :: " + value);
	}

	public static void methodReferenceStatic(int someInt, String someString) {
		System.out.println("methodReferenceStatic -----");
		String value = someString.concat(" age = ").concat(String.valueOf(someInt));
		System.out.println("combined value :: " + value);
	}
}
