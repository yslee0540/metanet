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
	
	public MemberDto getMember(String userid) {
		MemberDto member = new MemberDto();
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "select userid, name, password, email, address "
					   + "from member where userid = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userid);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				member.setUserid(rs.getString("userid"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
			} else {
				throw new RuntimeException("사용자가 없습니다");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			closeConnection(con);
		}
		return member;
	}
	
	public void updateMember(MemberDto member) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "update member set name=?, password=?, email=?, address=? "
					   + "where userid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getPassword());
			stmt.setString(3, member.getEmail());
			stmt.setString(4, member.getAddress());
			stmt.setString(5, member.getUserid());
			
			int rowCount = stmt.executeUpdate();
			if (rowCount <= 0) {
				throw new RuntimeException("변경된 행이 없습니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			closeConnection(con);
		}
	}
	
	public void deleteMember(String userid, String password) {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			String sql = "delete from member where userid=? and password=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userid);
			stmt.setString(2, password);
			
			int rowCount = stmt.executeUpdate();
			if (rowCount <= 0) {
				throw new RuntimeException("아이디 또는 비밀번호가 다릅니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			closeConnection(con);
		}
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
