package ch06.sec07.exam04;

public class Car {
	// 필드 선언(인스턴스 필드)
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;

	// 생성자 선언
	Car() {
		this(null, null, 0);
	}

	Car(String model) {
		// this.model = model;
		this(model, null, 0);
	}

	Car(String model, String color) {
		/* this.model = model;
		this.color = color; */
		this(model, color, 0);
	}

	Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
