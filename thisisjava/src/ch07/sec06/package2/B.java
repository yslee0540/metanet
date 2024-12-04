package ch07.sec06.package2;

import ch07.sec06.package1.A;

public class B extends A {
	public B() {
		super();
	}
	
	public void childMethod() {
		field = 10;
		method();
	}
}
