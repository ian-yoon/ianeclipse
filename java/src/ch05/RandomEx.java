package ch05;

import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {

		Random rand = new Random();
		int[] nums = new int[5];
		int sum = 0;

		for (int i = 0; i < 5; i++) {
			nums[i] = rand.nextInt(100) + 1;
			sum += nums[i];
			System.out.println(nums[i]);
		}

		System.out.println(sum);
		
		
	}

}
