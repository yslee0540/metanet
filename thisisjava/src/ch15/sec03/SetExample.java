package ch15.sec03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		
		Member m1 = new Member("홍길동", 25);
		Member m2 = new Member("감자바", 25);
		
		//객체 저장
		set.add(m1);
		set.add(m2);
		System.out.println(set.size());
		
		//객체 삭제
//		set.remove(m2); //동등 객체를 찾아 삭제
//		System.out.println(set.size());
		
		//객체 검색
		//iterable 인터페이스로 구현하고 있어야 사용 가능
		for (Member m : set) {
			System.out.println(m);
		}
		
		Iterator<Member> iterator = set.iterator();
		while (iterator.hasNext()) {
			Member m = iterator.next();
			System.out.println(m);
		}
	}

}
