package ch08.sec11.exam02;

public class BoardController {
	private MemberService memberService;
	private BoardService boardService;
	
	//매개변수에 인터페이스로 사용 가능한 객체가 올 수 있음
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	public void request1() {
		memberService.join();
		memberService.login();
	}
	
	public void request2() {
		boardService.write();
		boardService.read();
	}
}
