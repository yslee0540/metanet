package com.example.myweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmpDao {
	// 데이터소스 객체를 가져와 멤버변수에 저장
	static DataSource dataSource;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 데이터베이스 CRUD를 구현한 메서드 추가
	// 모든 사원의 수 조회
	public int getEmpCount() {
		int count = 0;
		
		Connection con = null;
		try {
			// 1. 커넥션 객체
			con = dataSource.getConnection();
			
			// 2. SQL 구문 객체
			String sql = "select count(*) from employees";
			
			// 3. Statement 객체 생성(Connection 객체 이용) -> SQL 구문을 실행하기 위해서
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// 4. SQL 구문 실행(Statement 객체 이용)
			// executeUpdate(): insert, update, delete
			ResultSet rs = stmt.executeQuery();
			
			// 5. ResultSet에서 결과를 조회
			if (rs.next()) {
				count = rs.getInt(1); //열의 순서
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// 6. 결과를 반환
		return count;
	}
}
