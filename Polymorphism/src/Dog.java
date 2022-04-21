
public class Dog extends Animal {
	
	//overriding
	public void eat() { 
		System.out.println("chomp");
	}
	
	public void eat(int numberOfTimes) {
		for(int i =0; i<numberOfTimes; i++) {
			System.out.println("Yum Yum Yum");
		}
		
	}

}
