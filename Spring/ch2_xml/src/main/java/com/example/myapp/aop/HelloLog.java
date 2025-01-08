package com.example.myapp.aop;

import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class HelloLog {
//	private static boolean isDebug = true;
//	
//	public static void log() {
//		if (isDebug) {
//			System.out.println(">>>LOG<<< : " + new java.util.Date());
//		}
//	}
	
	public void log(JoinPoint joinPoint) {
		System.out.println(">>>LOG<<< : " + new java.util.Date());
		Signature s = joinPoint.getSignature();
		System.out.println(">>>BEFORE LOG<<<: 핵심코드 메서드명 - " + s.getName());
		System.out.println("메서드가 선언된 곳 : " + s.getDeclaringTypeName());
		System.out.println("제한자 : " + s.getModifiers());
		System.out.println("제한자 : " + Modifier.toString(s.getModifiers()));
	}
	
	public void afterLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.toShortString();
		System.out.println(">>>AFTER LOG<<<: 핵심코드 메서드명 - " + methodName);
	}
	
	public void resultLog(JoinPoint joinPoint, Object resultObj) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println(">>>RESULT LOG<<<: 핵심코드 메서드명 - " + methodName);
		System.out.println("핵심코드의 반환 값 : " + resultObj);
	}
	
	public void exceptionLog(JoinPoint joinPoint, Exception exception) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println(">>>EXCEPTION LOG<<<: 핵심코드 메서드명 - " + methodName);
		System.out.println("예외 발생 - 메세지 : " + exception.getMessage());
	}
	
	public Object aroundLog(ProceedingJoinPoint joinPoint) {
		//ProceedingJoinPoint: JoinPoint의 하위 클래스
		Object result = null;
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println(">>>AROUND BEFORE LOG<<<: 메서드 이름 - " + methodName);
		try {
			result = joinPoint.proceed(); //핵심코드 실행
		} catch (Throwable e) {
			System.out.println(">>>AROUND EXCEPTION LOG<<< : 예외 메세지 - " + e.getMessage());
		} finally {
			System.out.println(">>>FINALLY<<<");
		}
		return result;
	}
	
	
}
