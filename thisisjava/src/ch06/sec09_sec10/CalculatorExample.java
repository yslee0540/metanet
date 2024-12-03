package ch06.sec09_sec10;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator calc1 = new Calculator("흰색", 100000);
		Calculator calc2 = new Calculator("검정", 200000);
		
		System.out.println(calc1.color);
		System.out.println(calc1.price);
		System.out.println(calc1.circleArea1(10));
		
		System.out.println(calc2.color);
		System.out.println(calc2.price);
		System.out.println(calc2.circleArea1(10));

		System.out.println(Calculator.company); //static
		System.out.println(Calculator.circleArea2(20));
	}

}
