package com.revature.models;

public class Cat implements Animal {

	@Override
	public void makeNoise() {
		System.out.println("Meow Meow");
		
	}

	@Override
	public void walk() {
		
		System.out.println("Jump Jump");
		
	}

	@Override
	public void eat() {
		System.out.println("I love milk");
		
	}

}
