package com.example.myweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {
	private String userid;
	private String name;
	private String password;
	private String email;
	private String address;
}
