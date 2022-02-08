package ch05;

public class IntArray {

	public static void main(String[] args) {
		
		int[] nums = {10, 20, 30, 40, 50};
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
//		System.out.println(nums.length);
		
//		확장 for문
		for (int n : nums) {
			System.out.println(n);
		}
			

	}

}
