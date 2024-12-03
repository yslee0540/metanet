package ch06.sec11.exam01;

public class KoreanExample {

	public static void main(String[] args) {
		Korean k1 = new Korean("123456-1234567");
		
		System.out.println(Korean.NATION);
		System.out.println(k1.ssn);
		
//		k1.nation = "미국인";
//		k1.ssn = "222";
//		System.out.println(k1.nation);
		
		Korean k2 = new Korean("333333-7777777");
		System.out.println(Korean.NATION);
		System.out.println(k2.ssn);
	}

}
