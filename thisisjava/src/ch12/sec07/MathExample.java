package ch12.sec07;

import java.util.Random;

public class MathExample {

	public static void main(String[] args) {
		double value1 = 3.4;
		
		long value2 = Math.round(value1);
		System.out.println(value2);
		
		int value3 = (int) Math.floor(value1);
		System.out.println(value3);
		
		int value4 = (int) Math.ceil(value1);
		System.out.println(value4);
		
		System.out.println(Math.random()); //0.0 <= x < 1.0
		System.out.println(Math.random() * 6);
		System.out.println((int)(Math.random() * 6)); //0, 1, 2, 3, 4, 5
		System.out.println((int)(Math.random() * 6) + 1);
		
		Random random = new Random();
		System.out.println(random.nextInt()); //정수 최소값~최대값
		System.out.println(random.nextDouble()); //0.0 <= x < 1.0
		System.out.println(random.nextInt(6) + 1);
	}

}
