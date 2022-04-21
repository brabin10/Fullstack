package com.java;

public class AverageValueOfArray {

	public static void main(String[] args) {

		int[] numbers = new int[] { 2, 30, 25, 35, -16, 60, -100 };
		int sum = 0;

		for (int i = 0; i < numbers.length; i++)
			sum = sum + numbers[i];

		double average = sum / numbers.length;
		System.out.println(average);
	}

//		int[] array = {20, 30, 25, 35, -16, 60, -100};
//        double sum = 0;
//        for (int i : array) {
//            sum += i;
//        }
//
//        double average =  sum / array.length;
//        System.out.println("Average value of the array elements is : " + average);
//		

}
