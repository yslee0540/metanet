package ch02.sec07_sec10;

public class TypeChangeExample {

	public static void main(String[] args) {
		//강제 타입 변환
		int var1 = 200;
//		byte var2 = (byte) var1;
		short var2 = (short) var1;
		System.out.println("var2: " + var2);
		
		//자동 타입 변환: 작 -> 큰
		byte var3 = 100;
		int var4 = var3;
		
		//실수 -> 정수
		double var5 = 3.14;
		int var6 = (int) var5;
		System.out.println("var6: " + var6);
		
		float var7 = 3.14f;
		long var8 = (long) var7;
		
		//정수 -> 실수
		int var9 = 3;
		double var10 = var9;
		
		//연산식에서 타입 변환
		byte var11 = 10;
		byte var12 = 20;
		//산술 연산 시 int로 바뀜
		int var13 = var11 + var12;
//		byte var13 = (byte) (var11 + var12);
		
	}

}
