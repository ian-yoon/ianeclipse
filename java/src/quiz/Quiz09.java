package quiz;

import java.util.Scanner;

public class Quiz09 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int year;
		int month;
		int day;

		System.out.println("연도를 입력하세요: \n 월을 입력하세요: ");
		year = sc.nextInt();
		month = sc.nextInt();
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 && month == 2) {
			day = 29;
			System.out.println(year + "년 " + month + "월의 날수는 " + day + "일입니다.");
		} else if (month % 2 == 0) {
			day = 31;
			System.out.println(year + "년 " + month + "월의 날수는 " + day + "일입니다.");
		} else if (month % 2 == 1) {
			day = 30;
			System.out.println(year + "년 " + month + "월의 날수는 " + day + "일입니다.");
		}
		
		sc.close();

	}

}
