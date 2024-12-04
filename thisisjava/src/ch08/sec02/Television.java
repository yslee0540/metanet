package ch08.sec02;

public class Television implements RemoteControl {
	//필드, 생성자, 메소드 추가 가능
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void volumeUp(int level) {
		System.out.println("TV 볼륨을 " + level + "로 올립니다.");
	}

	@Override
	public void volumeDown(int level) {
		System.out.println("TV 볼륨을 " + level + "로 내립니다.");
	}
	
}
