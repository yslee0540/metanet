package com.example.myweb.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.myweb.dao.MemberDao;
import com.example.myweb.model.MemberDto;

@WebServlet("/member/Member.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	MemberDao dao = new MemberDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String view = "index.jsp";
		
		//고정된 상수가 앞에 오는 것이 좋음(NullPointException)
		if ("insert".equals(action) || action == null) {
//			MemberDto member = new MemberDto();
//			request.setAttribute("member", member);
			request.setAttribute("action", "insert");
			view = "member/memberform.jsp";
		} else if ("select".equals(action)) {
			String userid = (String) session.getAttribute("userid");
			if (userid != null) {
				MemberDto member = dao.getMember(userid);
				request.setAttribute("member", member);
				request.setAttribute("action", "update");
				view = "member/memberform.jsp";
			} else {
				request.setAttribute("message", "로그인하지 않은 사용자입니다.");
				view = "loginform.jsp";
			}
		} else if ("delete".equals(action)) {
			request.setAttribute("action", "delete");
			view = "member/deleteform.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/" + view);
		disp.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if ("insert".equals(action)) {
			String userid = request.getParameter("userid");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			
			MemberDto member = new MemberDto(userid, name, password, email, address);
			try {
				dao.insertMember(member);
				//response.getWriter().append("ok");
				response.sendRedirect("/Login.do");
			} catch (Exception e) {
				//response.getWriter().append("Error: " + e.getMessage());
				response.sendRedirect("/member/Member.do?action=select");
			}
		} else if ("update".equals(action)) {
			String userid = (String)request.getSession().getAttribute("userid");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			
			if (userid == null) {
				throw new RuntimeException("로그인한 사용자가 없습니다.");
			} else {
				MemberDto member = new MemberDto(userid, name, password, email, address);
				dao.updateMember(member);
				response.sendRedirect("/member/Member.do?action=select");
			}
		} else if ("delete".equals(action)) {
			HttpSession session = request.getSession();
			String userid = (String)session.getAttribute("userid");
			String password = request.getParameter("password");
			if (userid != null) {
				dao.deleteMember(userid, password);
				session.invalidate();
				response.sendRedirect("/");
			} else {
				throw new RuntimeException("로그인한 사용자가 없습니다.");
			}
		}
	}

}
