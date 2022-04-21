package com.revature;

import com.revature.models.Cat;
import com.revature.models.Dog;
import com.revature.models.Snake;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog myDog = new Dog();
		myDog.makeNoise();
		myDog.eat();
		myDog.walk();
		
		Cat myCat = new Cat();
		myCat.eat();
		myCat.makeNoise();
		myCat.walk();
		
		Snake mySnake = new Snake();
		mySnake.makeNoise();
		mySnake.walk();
		mySnake.eat();

	}

}
