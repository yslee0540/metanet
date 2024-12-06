package ch15.sec02.exam02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import ch15.sec02.exam01.Board;

public class ArrayListVsVectorExample {

	public static void main(String[] args) {
		//List<Board> list = new ArrayList<>();
		List<Board> list = new Vector<>();

		Thread threadA = new Thread() {
			@Override
			public void run() {
				for (int i = 1; i <= 10000; i++) {
					list.add(new Board(i, "제목" + i, "내용" + i, "글쓴이" + i, new Date()));
				}
			}
		};

		Thread threadB = new Thread() {
			@Override
			public void run() {
				for (int i = 10001; i <= 20000; i++) {
					list.add(new Board(i, "제목" + i, "내용" + i, "글쓴이" + i, new Date()));
				}
			}
		};
		
		//스레드 작업을 시작
		threadA.start();
		threadB.start();
		
		//threadA와 threadB가 작업이 끝날 때까지 기다림
		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
		}
		
		System.out.println(list.size());
	}

}
