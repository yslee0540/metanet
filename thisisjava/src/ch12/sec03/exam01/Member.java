package ch12.sec03.exam01;

public class Member {
	public String id;
	public String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member target = (Member) obj;
			return id.equals(target.id) && name.equals(target.name);
		} else {
			return false;
		}
	}
}
