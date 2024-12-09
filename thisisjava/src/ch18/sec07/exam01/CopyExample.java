package ch18.sec07.exam01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
			
			BufferedInputStream bi = new BufferedInputStream(is);
			BufferedOutputStream bo = new BufferedOutputStream(os);
			
			byte[] data = new byte[1000];
			while (true) {
				int num = bi.read(data);
				if (num == -1) break;
				bo.write(data, 0, num);
			}
			
			bo.flush();
			bo.close();
			bi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
