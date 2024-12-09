package ch18.sec06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamExample {

	public static void main(String[] args) throws Exception {
		write("오늘은 월요일 입니다. 날씨가 춥네요.");
		String content = read();
		System.out.println(content);
	}
	
	public static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream("C:/Temp/test.txt");
		Writer writer = new OutputStreamWriter(os);
		writer.write(str);
		writer.flush();
		writer.close();
	}
	
	public static String read() throws Exception {
		InputStream is = new FileInputStream("C:/Temp/test.txt");
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		String data = br.readLine();
		br.close();
		return data;
	}

}
