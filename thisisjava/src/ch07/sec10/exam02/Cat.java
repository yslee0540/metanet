package ch07.sec10.exam02;

public class Cat extends Animal {

	public void catchMouse() {
		System.out.println("쥐를 잡습니다.");
	}
	
	@Override
	public void sound() {
		System.out.println("야옹");
	}
}
