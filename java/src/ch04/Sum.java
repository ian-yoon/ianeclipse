package ch04;

public class Sum {

	public static void main(String[] args) {

		int num = 10;
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				sum = sum + i;
			}
		}

		System.out.println(sum);

	}

}
