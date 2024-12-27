package com.example.myweb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

	String encoding = "utf-8";
	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		String userid = (String)session.getAttribute("userid");
		if (userid == null) {
			res.sendRedirect("/Login.do");
			return;
		}
		
		CharUpperWrapper requestWrapper = new CharUpperWrapper(req);
		//chain.doFilter(request, response);
		chain.doFilter(requestWrapper, response);
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}


}
