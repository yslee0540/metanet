package ch07.sec02;

public class SmartPhoneExample {

	public static void main(String[] args) {
		
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		System.out.println(myPhone.model);
		System.out.println(myPhone.color);
		System.out.println(myPhone.wifi);
		
		myPhone.bell();
		myPhone.sendVoice("안녕하세요");
		myPhone.setWifi(true);
		myPhone.internet();
	}

}
