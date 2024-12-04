package ch07.sec10.exam02;

public class Dog extends Animal {
	
	public void keepHouse() {
		System.out.println("집을 지킵니다.");
	}
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
