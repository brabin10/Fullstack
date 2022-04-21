package com.java;

public class MinMaxNumber {

	// Method for getting minimum value
	public static int getMin(int[] inputArray) {
		int minValue = inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] < minValue) {
				minValue = inputArray[i];
			}
		}
		return minValue;

	}

	// Method for getting maximum value
	public static int getMax(int[] inputArray) {
		int maxValue = inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] > maxValue) {
				maxValue = inputArray[i];
			}
		}

		return maxValue;

	}

	public static void main(String[] args) {

		int array[] = new int[] { 123, 343, 4, 56, 90, 24, 654 };

		int min = getMin(array);
		System.out.println("Minimum Value is: " + min);

		int max = getMax(array);
		System.out.println("Maximum Value is: " + max);

	}

}
