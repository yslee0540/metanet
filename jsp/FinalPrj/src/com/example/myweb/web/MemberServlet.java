package com.example.myweb.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.myweb.dao.MemberDao;
import com.example.myweb.model.MemberDto;

@WebServlet("/member/Member.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	MemberDao dao = new MemberDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		MemberDto member = new MemberDto(userid, name, password, email, address);
		
		try {
			dao.insertMember(member);
			response.getWriter().append("ok");
		} catch (Exception e) {
			response.getWriter().append("Error: " + e.getMessage());
		}
	}

}
