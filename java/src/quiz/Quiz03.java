package quiz;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int key;

		System.out.println("메뉴를 선택하세요!");
		System.out.println("1: 섭씨온도를 화씨로 바꾸기 2:화씨온도를 섭씨로 바꾸기");

		do {
			key = sc.nextInt();
			switch (key) {
			case 1:
				System.out.println("섭씨온도를 입력하세요.");
				double temp_c = sc.nextInt();
				double ctof = (temp_c * 1.8) + 32;
				System.out.println(temp_c + "의 화씨온도는 " + String.format("%.2f", ctof) + "입니다.");
				break;

			case 2:
				System.out.println("화씨온도를 입력하세요.");
				double temp_f = sc.nextInt();
				double ftoc = (temp_f - 32) / 1.8;
				System.out.println(temp_f + "의 섭씨온도는 " + String.format("%.2f", ftoc) + "입니다.");
				break;
			}

		} while (key != 0);

		sc.close();
	}

}
