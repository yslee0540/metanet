package ch15.sec04;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

		// 엔트리 저장
		map.put("자바", 85);
		map.put("자바스크립트", 90);
		map.put("스프링", 75);
		map.put("데이터베이스", 95);
		System.out.println(map);
		System.out.println(map.size());
		System.out.println();

		// 객체 검색
		int value = map.get("스프링");
		System.out.println(value);
		System.out.println();

		// 반복 처리
		for (Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			value = entry.getValue();
			System.out.println(key + ": " + value);
		}
		System.out.println();

		for (String key : map.keySet()) {
			value = map.get(key);
			System.out.println(key + ": " + value);
		}

		// 객체 삭제
		map.remove("자바");
		System.out.println(map);
	}

}
