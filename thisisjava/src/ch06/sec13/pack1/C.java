package ch06.sec13.pack1;

public class C {
	A a;
	B b;
	
	void method1() {
		a = new A(10);
		//a = new A(10.5);
		//a = new A("abc");
		
		System.out.println(a.f1);
		//System.out.println(a.f2);
		//System.out.println(a.f3);
		
		a.m1();
		a.m2();
		//a.m3();
	}
}
