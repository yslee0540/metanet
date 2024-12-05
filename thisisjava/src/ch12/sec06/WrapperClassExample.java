package ch12.sec06;

public class WrapperClassExample {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		
//		Integer obj1 = new Integer(3);
//		Integer obj2 = new Integer("3");
		
		Integer obj3 = 3;
		Integer obj4 = Integer.parseInt("3");
		Integer obj5 = Integer.valueOf("3");
		
		Double obj6 = 3.5;
		Double obj7 = Double.parseDouble("3.5");
		Double obj8 = Double.valueOf("3.5");
		
		
		int value1 = 3;
		Integer obj9 = 3;
		System.out.println(value1 == obj9.intValue());
	}

}
