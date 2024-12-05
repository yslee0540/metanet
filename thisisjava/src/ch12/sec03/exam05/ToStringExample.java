package ch12.sec03.exam05;

public class ToStringExample {

	public static void main(String[] args) {
		String str = "홍길동";
		System.out.println(str);
		System.out.println(str.toString());
		
		Member m1 = new Member("user1", "홍길동");
		System.out.println(m1);
		System.out.println(m1.toString());
	}

}
