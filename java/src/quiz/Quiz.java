package quiz;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		String name = sc.next();
		System.out.println("출생연도를 입력하세요.");
		int year = sc.nextInt();
		int age = 2021-year;		
		System.out.println(name + "님의 나이는 만 " + age + "세입니다.");
		
		String result = year % 2 == 0 ? "비대상" : "대상";
		System.out.println(name + "님은 올해 건강검진 " + result + "입니다.");

		sc.close();
		
	}

}
