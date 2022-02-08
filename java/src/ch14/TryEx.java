package ch14;

public class TryEx {

	public static void main(String[] args) {

		int[] num = { 10, 20, 30, 40, 50 };
		try {
			for (int i = 0; i <= num.length; i++) {
				System.out.println(num[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end");

	}

}
