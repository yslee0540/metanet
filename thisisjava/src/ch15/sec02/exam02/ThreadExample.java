package ch15.sec02.exam02;

public class ThreadExample {

	public static void main(String[] args) {
		Thread threadA = new Thread() {
			@Override
			public void run() {
				while(true) {
					System.out.println("A");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		
		Thread threadB = new Thread() {
			@Override
			public void run() {
				while (true) {
					System.out.println("B");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		
		threadA.start();
		threadB.start();
		
	}

}
