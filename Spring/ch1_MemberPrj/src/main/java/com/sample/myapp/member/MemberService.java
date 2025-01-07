package com.sample.myapp.member;

public class MemberService implements IMemberService {

	@Override
	public Member getMemberInfo() {
		Member member = new Member();
		member.setMemberId("1234");
		member.setName("aaa");
		member.setAge(20);
		member.setEmail("aa@gmail.com");
		return member;
	}
	
}
