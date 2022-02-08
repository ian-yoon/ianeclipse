package quiz;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Quiz11 {
	
	Scanner sc = new Scanner(System.in);
	
	public void calc() {
		
		Calendar cal = new GregorianCalendar();
		String put = sc.nextLine();
		String[] date = put.split("/");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1])-1;
		int day = Integer.parseInt(date[2]);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.MINUTE, day);
		
		int yoil = cal.get(Calendar.DAY_OF_WEEK);
		String result = "입력하신 날짜는 ";
		switch(yoil) {
		case 1: result +="일요일"; break;
		case 2: result +="월요일"; break;
		case 3: result +="화요일"; break;
		case 4: result +="수요일"; break;
		case 5: result +="목요일"; break;
		case 6: result +="금요일"; break;
		case 7: result +="토요일"; break;
		}
		result += "입니다.";
		System.out.println(result);
	}
	

	public static void main(String[] args) {
		
		System.out.println("날짜를 yyyy/MM/dd의 형태로 입력해 주세요. (입력 예시:2017/11/11)");
		
		Quiz11 q = new Quiz11();
		q.calc();

	}

}
