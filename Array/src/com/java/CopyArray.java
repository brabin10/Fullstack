package com.java;

import java.util.Arrays;

public class CopyArray {

	public static void main(String[] args) {
		
		int[] arr = {10, 34, 56,78, 97};
		int[] arr1 = arr;
		
		System.out.println("Original array: "+Arrays.toString(arr));
		System.out.println("Copied array: "+Arrays.toString(arr1));
	}
}
