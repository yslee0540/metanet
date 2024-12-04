package ch08.sec11.exam02;

public class Example {

	public static void main(String[] args) {
		BoardController bc = new BoardController();
		
		//bc.setMemberService(new MemberServiceImpl1());
		bc.setMemberService(new MemberServiceImpl2());
		bc.request1();
		
		bc.setBoardService(new BoardServiceImpl1());
		bc.request2();
	}

}
