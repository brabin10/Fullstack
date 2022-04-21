package com.java;

import java.util.Scanner;

public class CheckEvenOdd {
	

	public static void main(String[] args) {
		
		int num;
		
		System.out.println("Enter the number");
		Scanner scan = new Scanner(System.in);
		
		num = scan.nextInt();
		
		if (num % 2 == 0) {
			System.out.println("Entered number is even");
			
		} else {
			System.out.println("Entered number is odd");
		}
		
		
		
	}
	}
	
	