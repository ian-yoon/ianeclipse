package ch14;

public class ThrowsEx {

	public static void main(String[] args) throws InterruptedException {

		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
			Thread.sleep(500);
		}

	}

}
