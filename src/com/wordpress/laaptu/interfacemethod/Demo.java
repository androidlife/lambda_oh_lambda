package com.wordpress.laaptu.interfacemethod;

public class Demo {

	/**
	 * Functional Interface only needs to have one abstract method and if there
	 * is needed, there will be either static methods or default method names, w
	 * which will have method implementation within that interface only
	 */
	public interface IPrintStore {
		void printName(String s);

		default void storeName(String s) {
			System.out.println(String.format("Store this %s to database", s));
		}

		public static String addExtraName(String s) {
			String value = s.concat(" :This is extra");
			return value;
		}
	}

	public static void main(String[] args) {
		demo();
	}

	public static void demo() {
		IPrintStore iprintStore = (s) -> System.out.println(String.format("You need to print this name =%s", s));
		iprintStore.printName("Lambda");
		iprintStore.storeName("Lambda");

	}
	


}
