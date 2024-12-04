package ch08.sec12;

public interface RemoteControl {
	//상수 정의
	public int MAX_VALUE = 10;
	public int MIN_VALUE = 0;
	
	//사용 방법을 추상 메소드 형태로 정의
	//기본 public
	public void turnOn();
	void turnOff();
	
	public void volumeUp(int level);
	public void volumeDown(int level);
}
