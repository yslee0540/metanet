package ch07.sec10.exam02;

public class AbstractClassExample {

	public static void main(String[] args) {
		//Animal animal = new Animal();
		Animal animal = new Dog();
		animal.sound();
		
		Animal animal2 = new Cat();
		animal2.sound();
	}

}
