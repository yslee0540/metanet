package ch06.sec14;

public class MemberExample {

	public static void main(String[] args) {
		Member m1 = new Member();
		
		//m1.id = "user";
		System.out.println(m1.getId());
		m1.setId("user1");
		System.out.println(m1.getId());
		
		//public 사용시
		//m1.age = -20; 가능
		//조건문 추가해서 올바른 값만 넣을 수 있음
		m1.setAge(-20);
	}

}
