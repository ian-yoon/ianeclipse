package ch05;

public class Array2D {

	public static void main(String[] args) {

		// 대괄호[] : 배열첨자
		int[][] nums = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } };
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(nums[i][j]);
			}
		}

		System.out.println(nums.length); // 행의 개수
		System.out.println(nums[0].length); // 열의 개수
		
	}

}
