package ch08.sec11.exam02;

public class MemberServiceImpl2 implements MemberService {

	@Override
	public void join() {
		System.out.println("VIP 회원으로 가입합니다.");
	}

	@Override
	public void login() {
		System.out.println("VIP 회원으로 로그인합니다.");
	}

}
