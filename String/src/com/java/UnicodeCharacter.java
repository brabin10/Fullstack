package com.java;

public class UnicodeCharacter {
	public static void main(String[] args) {
		
	//Unicode At
//	String str = "Java Exercise";
//	
//	int val1 = str.codePointAt(7);
//	int val2 = str.codePointAt(4);
//	
//	System.out.println("Character(unicode point)= "+val1);
//	System.out.println("Character(unicode point)= "+val2);
		
		
		//Unicode before
		String  str = "Java Exercise";
		
		int val1 = str.codePointBefore(7);
		int val2 = str.codePointBefore(4);
		
		System.out.println("Charactr(unicode point)= "+val1);
		System.out.println("Character(unicode point)= "+val2);
	}
}
