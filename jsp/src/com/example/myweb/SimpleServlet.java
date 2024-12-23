package com.example.myweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
//@WebServlet({ "/SimpleServlet", "/simple.do" })
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SimpleServlet() {
    	System.out.println("기본생성자 호출");
    }
    
    private ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException {
    	this.config = config;
    	System.out.println("서블릿 init 메서드 호출");
    	String path = config.getInitParameter("filepath");
    	System.out.println(path);
//    	super.init(config);
    }

	@Override
	public void destroy() {
		System.out.println("SimpleServlet이 소멸됩니다.");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>");
		out.println("Hello Servlet");
		out.println("</h1>");
		System.out.println("doGet 메서드 호출");
		
		String nameParam = request.getParameter("name");
		out.println("파라미터 값: " + nameParam);
//		response.getWriter().append("Served at: ").append(request.getContextPath()).append("<h1>HelloServlet</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
