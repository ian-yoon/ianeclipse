package quiz;

import java.util.GregorianCalendar;
import java.util.Scanner;

class Days {
	private int year;
	private int month;
	private int result;

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("연도를 입력하세요:");
		year = sc.nextInt();
		System.out.print("월을 입력하세요:");
		month = sc.nextInt();
		
		calc();
	}
// int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
	public void calc() {
		switch (month) {
		case 2:
			// 윤년 여부 판단
			GregorianCalendar cal = new GregorianCalendar();
			if (cal.isLeapYear(year)) { // 윤년인 경우
				result = 29;
			} else { //평년인 경우
				result = 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			result = 30;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			result = 31;
			break;
		}
	}
	@Override
	public String toString() {
		return year+"년 "+month+"월의 날수는 "
				+result+"일입니다.";
	}
}

public class Ex09_days {
	public static void main(String[] args) {
		Days d = new Days();
		d.input();
		System.out.println(d);
	}
}
