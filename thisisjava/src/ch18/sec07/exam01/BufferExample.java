package ch18.sec07.exam01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferExample {

	public static void main(String[] args) throws Exception {
		String ofile1 = "C:/Temp/image1_1.png";
		String tfile1 = "C:/Temp/image1_2.png";
		String ofile2 = "C:/Temp/image2_1.png";
		String tfile2 = "C:/Temp/image2_2.png";
		
		//버퍼를 사용하지 않는 스트림
		FileInputStream fis = new FileInputStream(ofile1);
		FileOutputStream fos = new FileOutputStream(tfile1);
		
		//버퍼를 사용하는 스트림
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(ofile2));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tfile2));
		
		//복사 성능 테스트
		long nonBufferTime = copy(fis, fos);
		System.out.println("버퍼 (x): " + nonBufferTime + "ns");
		long bufferTime = copy(bis, bos);
		System.out.println("버퍼 (o): " + bufferTime + "ns");
		
//		fis.close();
//		fos.close();
//		bis.close();
//		bos.close();
	}
	
	public static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();
		
		while (true) {
			int data = is.read();
			if (data == -1) break;
			os.write(data);
		}
		
		long end = System.nanoTime();
		return end - start;
	}
}
