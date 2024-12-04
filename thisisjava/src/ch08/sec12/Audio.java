package ch08.sec12;

//RemoteControl 인터페이스로 사용할 수 있도록 만드는 것
public class Audio implements RemoteControl {
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}

	@Override
	public void volumeUp(int level) {
		System.out.println("Audio 볼륨을 " + level + "로 올립니다.");
	}

	@Override
	public void volumeDown(int level) {
		System.out.println("Audio 볼륨을 " + level + "로 내립니다.");
	}
	
}
