package com.example.myweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/Form.do")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String[] fruits = request.getParameterValues("fruit");
		String sex = request.getParameter("sex");
		String job = request.getParameter("job");
		String data = request.getParameter("data");
		String fileName = request.getParameter("file");
		
		out.println("아이디: " + id + "<br>");
		out.println("비밀번호: " + pw + "<br>");
		out.print("좋아하는 과일: ");
		for (int i = 0; i < fruits.length; i++) {
			out.print(fruits[i] + " ");
		}
		out.println("<br>");
		out.println("성별: " + sex + "<br>");
		out.println("직업: " + job + "<br>");
		out.println("텍스트: " + data.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;") + "<br>");
		out.println("파일명: " + fileName + "<br>");
	}

}
