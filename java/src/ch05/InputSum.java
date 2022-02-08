package ch05;

import java.util.Scanner;

public class InputSum {

	public static void main(String[] args) {

		int[] nums = new int[5];
		int sum = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("Write down FIVE numbers.");
		for (int i = 0; i < nums.length; i++) {
			System.out.println("Number " + (i + 1) + ":");
			nums[i] = scan.nextInt();
			sum = sum + nums[i];
		}
		System.out.println("Sum of FIVE numbers is: " + sum);

		scan.close();

	}

}
