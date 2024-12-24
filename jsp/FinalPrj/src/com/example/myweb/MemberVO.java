package com.example.myweb;

public class MemberVO {
	private String userid;
	private String name;
	private String password;
	private String email;
	private String address;
	
	public MemberVO() {
	}
	
	public MemberVO(String userid, String name, String password, String email, String address) {
		this.userid = userid;
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
