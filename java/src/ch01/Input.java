package ch01;

import java.util.Scanner;

public class Input {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Scanner라는 class의 내용을 메모리에 불러와주는 new
		// (System.in)은 입력장치(키보드)를 불러옴
		// 참조변수로 sc를 설정한 것
		System.out.println("이름을 입력하세요.");
		String name = sc.next();
		System.out.println("Name: " + name);
		System.out.println("나이를 입력하세요.");
		int age = sc.nextInt();
		System.out.println("Age: " + age);

		sc.close();

	}

}
