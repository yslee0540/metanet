package ch06.sec13.pack1;

public class A {
	public int f1;
	int f2;
	private int f3;
	
	public A(int x) {}
	A(double y) {}
	private A(String z) {}
	
	void method() {
		System.out.println(f3);
	}
	
	public void m1() {}
	void m2() {}
	private void m3() {}
	
	void test() {
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		
		A obj1 = new A(10);
		A obj2 = new A(10.5);
		A obj3 = new A("abc");
		
		m1();
		m2();
		m3();
	}
}
