package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/Temp/test2.db");
			
			//읽은 바이트를 저장할 배열 생성
			byte[] data = new byte[100];
			
			while (true) {
				int num = is.read(data); //한 번에 100바이트 읽을 수 있음
				if(num == -1) {
					break;
				}
				
				for (int i = 0; i < num; i++) {
					System.out.print(data[i] + ", ");
				}
				System.out.println();
			}
			
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
