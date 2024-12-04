package ch08.sec11.exam02;

public class BoardServiceImpl1 implements BoardService {

	@Override
	public void write() {
		System.out.println("자유 게시판에 글을 씁니다.");
	}

	@Override
	public void read() {
		System.out.println("자유 게시판의 글을 읽습니다.");
	}

}
