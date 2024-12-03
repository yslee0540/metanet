package ch06.sec09_sec10;

public class Calculator {
	//인스턴스 필드
	String color;
	int price;
	//정적 필드
	static String company = "LG";
	static double pi = 3.14;
	
	Calculator(String color, int price) {
		this.color = color;
		this.price = price;
	}
	
	//인스턴스 메소드
	double circleArea1(double radius) {
		System.out.println(this.color);
		return radius * radius * Calculator.pi;
	}
	
	//정적 메소드
	static double circleArea2(double radius) {
		//System.out.println(this.color); //this 자체가 불가능
		return radius * radius * pi;
	}
}
