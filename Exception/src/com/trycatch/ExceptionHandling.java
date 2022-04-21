package com.trycatch;

public class ExceptionHandling {

	public static void main(String[] args) {

		try {
			getInt();
		}

		catch (NumberFormatException | NullPointerException e) { // multi catch statements
			System.out.println("You can't make an int out of that. Stop it ");

		}
		//finally code always execute no matter what
		finally {
			System.out.println("in the finally block");

		}
		System.out.println("End here");
	}

	private static void getInt() {
		int myInt = Integer.parseInt("apple");

	}
}
