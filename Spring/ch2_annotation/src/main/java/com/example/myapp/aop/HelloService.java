package com.example.myapp.aop;

public class HelloService implements IHelloService {

	@Override
	public String sayHello(String name) {
		System.out.println("HelloService.sayHello() 호출됨");
		int rand = (int)(Math.random() * 10);
		if (rand < 5) {
			throw new RuntimeException("강제예외 발생");
		}
		String message = "Hello " + name;
		return message;
	}

	@Override
	public String sayGoodbye(String name) {
		System.out.println("HelloService.sayGoodbye() 호출됨");
		String message = "Goodbye " + name;
		return message;
	}
	
}
