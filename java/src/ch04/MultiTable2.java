package ch04;

public class MultiTable2 {

	public static void main(String[] args) {

		for (int i = 2; i <= 9; i++) {
			System.out.println("\n" + "[table " + i + "]");
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + "x" + j + "=" + i * j);
			}
		}

	}

}
