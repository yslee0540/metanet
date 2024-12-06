package ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/Temp/test1.db");
			
			while (true) {
				int data = is.read();
				//더 이상 읽을 바이트가 없을 때 -1 리턴
				if(data == -1) {
					break;
				}
				System.out.println(data);
			}
			
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
