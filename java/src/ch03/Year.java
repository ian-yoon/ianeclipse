package ch03;

import java.util.Scanner;

public class Year {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Year: ");
		int year = sc.nextInt();

		// 윤년은 4의 배수이지만 100의 배수는 아니고, 400의 배수는 맞음
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			System.out.println(year + " is a leap year.");
		} else {
			System.out.println(year + " is not a leap year.");
		}

		sc.close();
	}

}
