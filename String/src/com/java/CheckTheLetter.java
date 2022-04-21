package com.java;

public class CheckTheLetter {
// Write a program to check if the letter'e' is present in the word 'Umbrella'
	public static void main(String[] args) {
		String str = "Umbrella";
		boolean bol = false;
		
		for (int i = 0;i < str.length();i++) {
			if(str.charAt(i)=='e') {
				bol = true;
				break;
				
			}
		}
		System.out.println(bol);
	}
}
