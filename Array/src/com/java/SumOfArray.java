package com.java;

import java.util.Arrays;

// Write a Java program to sum values of an array.
public class SumOfArray {
	public static void main(String[] args) {

		int[] my_array = { 132, 345, 5545, 324, 435 };

		int sum = 0;

		// int sum = Arrays.stream(my_array).sum();

		// System.out.println(Arrays.stream(my_array).sum()); // Method one to solve

		for (int i : my_array) { // Method two to solve
			sum += i;
		}
		System.out.println("The sum is: " + sum);

	}

}
