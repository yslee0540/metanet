package com.example.myapp.di;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	
//	@Autowired
//	@Qualifier("niceService")
	@Inject
	IHelloService helloService;
	
	public void hello(String name) {
		System.out.println("HelloController: " + helloService.sayHello(name));
	}
}
