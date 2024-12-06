package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static void main(String[] args) {
		try {
			String oFileName = "C:/Temp/image1.png";
			String tFileName = "C:/Temp/image2.png";
			
			InputStream is = new FileInputStream(oFileName);
			OutputStream os = new FileOutputStream(tFileName);
			
			//배열 크기 커지면 메모리 많이 사용하게 됨
			byte[] data = new byte[1000];
			while (true) {
				int num = is.read(data);
				if (num == -1) break;
				os.write(data, 0, num);
			}
			//is.transferTo(os); //자바 9 이후
			
			os.flush();
			os.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
