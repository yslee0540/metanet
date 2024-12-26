package com.example.myweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.example.myweb.model.MemberDto;

public class MemberDao {
	static DataSource dataSource;
	
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void insertMember(MemberDto member) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "insert into member values(?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getUserid());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getPassword());
			stmt.setString(4, member.getEmail());
			stmt.setString(5, member.getAddress());
			
			int rowCount = stmt.executeUpdate();
			if (rowCount <= 0) {
				throw new SQLException("저장된 행이 없습니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
			// 예외의 원인이 sql구문에 없을 경우 호출한 부분에서 에러를 알려주기 위해 사용
			// servlet이 SQLException에 의존하지 않게 하기 위해 사용
			throw new RuntimeException(e);
		} finally {
			if (con != null) try { con.close(); } catch (Exception e) {}
		}
	}
	
	public String getPassword(String userid) {
		String pw = "";
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select password from member where userid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userid);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				pw = rs.getString("password");
			} else {
				throw new SQLException("아이디가 없습니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			closeConnection(con);
		}
		return pw;
	}
	
	private void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
			}
		}
	}
}
