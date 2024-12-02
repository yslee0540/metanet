package ch03.sec06;

public class CompareOperatorExample {

	public static void main(String[] args) {
		int num3 = 1;
		double num4 = 1.0;
		System.out.println("result5: " + (num3 == num4)); //true
		
		float num5 = 0.1f;
		double num6 = 0.1;
		System.out.println("result6: " + (num5 == num6)); //false
		System.out.println("result7: " + (num5 == (float)num6)); //true
	}

}
