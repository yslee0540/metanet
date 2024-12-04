package ch08.sec02;

public class UseRemoteControlExample {

	public static void main(String[] args) {
		//인터페이스 타입의 변수를 선언
		RemoteControl rc;
		
		//인터페이스와 객체 연결
		//다형성
		//rc = new Television();
		rc = new Audio();
		
		//인터페이스 객체 사용
		rc.turnOn();
		rc.volumeUp(3);
		rc.turnOff();
	}

}
