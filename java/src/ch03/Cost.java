package ch03;

import java.util.Scanner;

public class Cost {

	public static void main(String[] args) {

		int point_use = 0;
		int fee = 0;
		int pay = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		String name = sc.next();
		System.out.println("가격을 입력하세요.");
		int price = sc.nextInt();
		System.out.println("포인트: ");
		int point = sc.nextInt();

		if (price < 20000) {
			fee = 2000;
		}
		if (point >= 10000) {
			if (point > price) { // 중첩 if
				point_use = price;
			} else {
				point_use = point;
			}
			pay = price + fee - point_use;
		} else {
			pay = price + fee;
		}

		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("Fee: " + fee);
		System.out.println("Point used: " + point_use);
		System.out.println("Pay: " + pay);

		sc.close();

	}

}
