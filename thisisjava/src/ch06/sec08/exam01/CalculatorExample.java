package ch06.sec08.exam01;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator myCalc = new Calculator();
		
		myCalc.powerOn();
		
		int result = myCalc.plus(5, 6);
		System.out.println("result1: " + result);
		
		int x = 10;
		int y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println("result2: " + result2);
		
		myCalc.powerOff();
	}

}
