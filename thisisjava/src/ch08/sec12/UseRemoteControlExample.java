package ch08.sec12;

public class UseRemoteControlExample {
	public static void use(RemoteControl rc) {
		rc.turnOn();
		rc.volumeUp(3);
		rc.volumeDown(2);
		rc.turnOff();
		
		if (rc instanceof Television) {
			Television tv = (Television) rc;
			tv.display();
		}
	}

	public static void main(String[] args) {
		use(new Television());
	}

}
