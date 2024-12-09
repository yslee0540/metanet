package ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class ReadLineExample {

	public static void main(String[] args) throws Exception {
		printCode1();
		System.out.println("-------------------------------");
		printCode2();
	}
	
	public static void printCode1() throws Exception {
		Reader reader = new FileReader("C:\\metanet\\eclipse-workspace\\thisisjava\\src\\ch18\\sec07\\exam02\\ReadLineExample.java");
		char[] data = new char[100];
		while (true) {
			int num = reader.read(data);
			if(num == -1) break;
			String str = new String(data, 0, num);
			System.out.println(str);
		}
		reader.close();
	}
	
	public static void printCode2() throws Exception {
		Reader reader = new FileReader("C:\\metanet\\eclipse-workspace\\thisisjava\\src\\ch18\\sec07\\exam02\\ReadLineExample.java");
		BufferedReader br = new BufferedReader(reader);
		while (true) {
			String line = br.readLine();
			if(line == null) break;
			System.out.println(line);
		}
		br.close();
	}

}
