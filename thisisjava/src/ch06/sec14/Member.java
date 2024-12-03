package ch06.sec14;

public class Member {
	private String id;
	private String email;
	private String name;
	private int age;
	private boolean adult;
	private String ssn; //123456-1234567
	
	//Getter
	public String getId() {
		return id;
	}
	
	public int getAge() {
		return age;
	}
	
	//값 가공해서 사용 가능
	public String getSsn() {
		return ssn.substring(0, 7);
	}
	
	//boolean은 is로 시작
	public boolean isAdult() {
		return adult;
	}

	//Setter
	public void setId(String id) {
		this.id = id;
	}
	
	public void setAge(int age) {
		if (age < 0) {
			this.age = 0;
		} else if (age > 150) {
			this.age = 150;
		} else {
			this.age = age;
		}
	}
}
