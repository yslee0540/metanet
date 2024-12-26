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

@WebServlet("/Login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDao dao = new MemberDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("loginform.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		String view = "loginok.jsp";
		
		try {
			String dbpw = dao.getPassword(userid);
			if (dbpw.equals(password)) {
				session.setAttribute("userid", userid);
				request.setAttribute("message", userid + "님 환영합니다.");
				response.sendRedirect("loginform.jsp");
				return;
			} else {
				throw new RuntimeException("비밀번호가 다릅니다.");
//				session.invalidate();
//				request.setAttribute("message", "비밀번호가 다릅니다.");
//				view = "loginerror.jsp";
			}
		} catch (RuntimeException e) {
			session.invalidate();
			request.setAttribute("message", e.getMessage());
			view = "loginerror.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher(view);
		disp.forward(request, response);
	}

}
