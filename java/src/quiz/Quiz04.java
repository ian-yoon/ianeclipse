package quiz;

import java.util.Random;
import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {

		Random rand = new Random();
		int num = rand.nextInt(100) + 1;
		int input_number;
		int count = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("1부터 100 사이의 랜덤한 숫자가 정해졌습니다.\n숫자를 맞춰보세요.");

		while (true) {
			input_number = sc.nextInt();
			count++;
			if (num == input_number) {
				System.out.println("정답입니다! 총 " + count + "회 시도하였습니다.");
				break;
			} else if (num > input_number) {
				System.out.println("좀 더 높은 수를 입력하세요.");
			} else if (num < input_number) {
				System.out.println("좀 더 낮은 수를 입력하세요.");
			}
		}

		sc.close();
	}

}
