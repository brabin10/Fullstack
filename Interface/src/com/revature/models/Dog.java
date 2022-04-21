package com.revature.models;

public class Dog implements Animal {

	@Override
	public void makeNoise() {
		System.out.println("Woof Woof");
		
	}

	@Override
	public void walk() {
		System.out.println("Lets go for walk");		
	}

	@Override
	public void eat() {
		System.out.println("Num Num Num");		
	}

	

}
