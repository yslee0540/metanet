package ch07.sec09;

public class InstanceOfExample {

	public static void personInfo(Person person) {
		System.out.println(person.name);
		person.walk();
		
		if (person instanceof Student) {
			Student s = (Student) person;
			System.out.println(s.studentNo);
			s.study();
		}
	}

	public static void main(String[] args) {
		personInfo(new Person("홍길동"));
		personInfo(new Student("감자바", 10));
	}

}
