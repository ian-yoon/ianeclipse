package ch04;

import java.util.Scanner;

public class MultiTable1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int num = sc.nextInt();
		System.out.println("구구단 "+num+"단");
		for (int i = 1; i <= 9; i++) {
			System.out.println(num + "x" + i + "=" + num*i);
		}

		sc.close();
		
	}

}
