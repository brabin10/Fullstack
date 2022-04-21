package com.java;

import java.util.Arrays;

public class ArrayStringSort {
// Write a program to  sort an numeric array and a string array
	public static void main(String[] args) {

		int[] my_array1 = { 9883, 3783, 2834, 9332, 1934, 1234};
		
		String[] my_array2 = { "C Programming", "C++", "C#", "Java", "Python", "PHP"};
		
		System.out.println("Original numeric array: " +Arrays.toString(my_array1));
		Arrays.sort(my_array1);
		System.out.println("Sorted numeric array: " +Arrays.toString(my_array1));
		
		System.out.println("Original string array: "+Arrays.toString(my_array2));
		Arrays.sort(my_array2);
		System.out.println("Sorted string array: "+Arrays.toString(my_array2));
	}

}
