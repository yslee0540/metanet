package com.example.myweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.myweb.dao.EmpDao;

@WebServlet("/Emp.do")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmpDao dao = new EmpDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = dao.getEmpCount();
		System.out.println(dao.getEmpCount());
		
		request.setAttribute("count", count);
		RequestDispatcher disp = request.getRequestDispatcher("result.jsp");
		disp.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
