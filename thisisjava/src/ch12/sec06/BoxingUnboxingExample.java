package ch12.sec06;

public class BoxingUnboxingExample {

	public static void main(String[] args) {
		//int value = 100;
		Integer obj = 100;
		System.out.println(obj);
		
		int value = obj;
		System.out.println(value);
		
		int result = obj + 100;
		System.out.println(result);
		
		//매개변수: 자동으로 객체로 포장됨(박싱)
		method(true);
	}
	
	public static void method(Object obj) {
		System.out.println(obj);
	}

}
