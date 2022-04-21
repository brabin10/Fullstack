package com.java;

public class StringConcat {

	public static void main(String[] args) {
		
		String str1 = "Java is a OOP language. ";
		String str2 = "It is strongly typed. ";
		
		//Concatenate the two strings together
		String str3 = str1.concat(str2);
		
		System.out.println("The concatenated string:  " +str3);

	}

}
