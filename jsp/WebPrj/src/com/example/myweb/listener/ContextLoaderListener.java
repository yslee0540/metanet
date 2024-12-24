package com.example.myweb.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("컨텍스트가 종료됩니다.");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce)  { 
        // 컨텍스트가 초기화(로드)될 때 호출되는 메서드
    	// web.xml의 context-param 불러옴
    	ServletContext context = sce.getServletContext();
    	String jdbcUrl = context.getInitParameter("jdbcUrl");
    	System.out.println("컨텍스트가 로드됩니다.");
    	System.out.println(jdbcUrl);
    }
	
}
