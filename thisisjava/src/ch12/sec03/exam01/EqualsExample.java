package ch12.sec03.exam01;

public class EqualsExample {

	public static void main(String[] args) {
		Member m1 = new Member("user1", "홍길동");
		Member m2 = new Member("user1", "홍길동");
		
		System.out.println(m1 == m2);
		System.out.println(m1.id.equals(m2.id));
		System.out.println(m1.name.equals(m2.name));
		
//		if (m1.id.equals(m2.id) && m1.name.equals(m2.name)) {
//			System.out.println("같은 회원입니다.");
//		} else {
//			System.out.println("다른 회원입니다.");
//		}
		
		if (m1.equals(m2)) {
			System.out.println("같은 회원입니다.");
		} else {
			System.out.println("다른 회원입니다.");
		}
	}

}
