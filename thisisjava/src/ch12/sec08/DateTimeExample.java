package ch12.sec08;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeExample {

	public static void main(String[] args) {
		//현재 컴퓨터 기준
		Date date = new Date();
		dateInfo(date);
		useCalendar();
		useLocalDateTime();
	}
	
	public static void dateInfo(Date date) {
		System.out.println(date); //toString()
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		System.out.println(sdf.format(date));
	}
	
	public static void useCalendar() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(year + " " + month + " " + day + " " + week);
	}
	
	public static void useLocalDateTime() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
		System.out.println(ldt.format(dtf));
		
		LocalDateTime result1 = ldt.plusYears(1);
		System.out.println(result1.format(dtf));
		
		LocalDateTime result2 = ldt.minusMonths(2);
		System.out.println(result2.format(dtf));
		
		LocalDateTime result3 = ldt.plusDays(7);
		System.out.println(result3.format(dtf));
	}

}
