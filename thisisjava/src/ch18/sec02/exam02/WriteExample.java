package ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/Temp/test2.db");
			
			byte[] array = new byte[120];
			for (int i = 0; i < array.length; i++) {
				array[i] = (byte) i;
			}
			
			os.write(array);
			
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
