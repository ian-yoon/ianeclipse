package quiz;

import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = 0;
		int sum1 = 0, sum2 = 0;

		System.out.println("1부터 100 사이의 숫자를 입력하세요.");
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				sum1 += i;
			} else {
				sum2 += i;
			}
		}

		System.out.println("짝수합계:" + sum1);
		System.out.println("홀수합계:" + sum2);

		sc.close();

	}
}
