package ch15.sec02.exam01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListExample {

	public static void main(String[] args) {
		// List<Board> list = new ArrayList<Board>();
		// List<Board> list = new Vector<>();
		List<Board> list = new LinkedList<>();

		// 객체 추가
		for (int i = 1; i <= 5; i++) {
			list.add(new Board(i, "제목" + i, "내용" + i, "글쓴이" + i, new Date()));
		}

		list.add(1, new Board(6, "제목6", "내용6", "글쓴이6", new Date()));
		list.set(2, new Board(7, "제목7", "내용7", "글쓴이7", new Date()));

		System.out.println(list.size());
		System.out.println(list.toString());
		System.out.println();

		// 객체 검색
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();

		for (Board board : list) {
			System.out.println(board);
		}
		
		Board board = list.get(1);
		System.out.print(board.getBno() + " | ");
		System.out.print(board.getTitle() + " | ");
		System.out.print(board.getContent() + " | ");
		System.out.print(board.getWriter() + " | ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(board.getDate()));

		// 객체 삭제
		list.remove(0);
		list.remove(board);
		System.out.println(list.size());
		// list.clear();
	}

}
