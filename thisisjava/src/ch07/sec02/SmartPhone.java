package ch07.sec02;

public class SmartPhone extends Phone {
	// 필드 선언
	public boolean wifi;

	// 생성자 선언
	public SmartPhone(String model, String color) {
		// 매개변수 있으면 무조건 필요
		super(model, color); // 상속 시 자동으로 생성(부모의 생성자 호출하는 코드)

		System.out.println("자식 생성자 실행");
		
//		super();
//		this.model = model;
//		this.color = color;
	}

	// 메소드 선언
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}

	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
}
