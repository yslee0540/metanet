package com.example.myweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.myweb.dao.AddDAO;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/Add.do")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터를 조회한다.
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		
		//2. 조회한 파라미터를 처리하기 적합한 타입으로 형변환
		int num1 = Integer.parseInt(op1);
		int num2 = Integer.parseInt(op2);
		
		//3. Model의 Biz()를 호출해서 작업을 처리한다.
		AddDAO dao = new AddDAO();
		int result = dao.add(num1, num2);
		
		//4. 처리 결과를 request 객체에 저장한다.
		request.setAttribute("result", result);
		
		//5. 결과를 보여주는 View 페이지로 forward(redirect 아님)한다.
		RequestDispatcher disp = request.getRequestDispatcher("addresult.jsp");
		disp.forward(request, response);
	}

}
