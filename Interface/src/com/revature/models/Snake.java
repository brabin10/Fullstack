package com.revature.models;

public class Snake implements Animal {

	@Override
	public void makeNoise() {
		System.out.println("Hiss Hiss");
		
	}

	@Override
	public void walk() {
		System.out.println("crul crul");
		
	}

	@Override
	public void eat() {
		System.out.println("eat rat");
		
	}

}
