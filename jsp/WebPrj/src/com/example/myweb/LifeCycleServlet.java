package com.example.myweb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletConfig config;
	String adminEmail;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		adminEmail = config.getInitParameter("email");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = config.getServletContext();
		String jdbcUrl = context.getInitParameter("jdbcUrl");
		
		InputStream in = context.getResourceAsStream("/WEB-INF/sample.txt");
		Scanner scanner = new Scanner(in);
		StringBuffer text = new StringBuffer();
		while(scanner.hasNext()) {
			text.append(scanner.nextLine() + "\n");
		}
		
		response.getWriter()
			.append(adminEmail)
			.append(", ")
			.append(jdbcUrl + ", ")
			.append(text.toString());
		scanner.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
