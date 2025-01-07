package com.example.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.example.myapp.di.HelloController;
import com.example.myapp.di.HelloService;
import com.example.myapp.di.IHelloService;

@Configuration
@ComponentScan(basePackages= {"com.example.myapp"})
@ImportResource(value= {"classpath:application-config.xml"})
public class AppConfig {
	@Bean
	IHelloService helloService() {
		return new HelloService();
	}
	
	@Bean
	HelloController helloController() {
		HelloController controller = new HelloController();
		controller.setHelloService(helloService());
		return controller;
	}
}
