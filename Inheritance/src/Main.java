
public class Main {

	public static void main(String[] args) {
		
		Mouse1 m1 = new Mouse1();
		Mouse2 m2 = new Mouse2();
		
		
		m1.leftClick();
		m1.rightClick();
		m1.scrollUp();
		m1.scrollDown();
		
		
		m2.leftClick();
		m2.rightClick();
		m2.scrollUp();
		m2.scrollDown();
		
		m2.connect();
		
		
		System.out.println(m1.version);
		
		System.out.println(m1.texture);
		
		System.out.println(m2.color);
	}

}
