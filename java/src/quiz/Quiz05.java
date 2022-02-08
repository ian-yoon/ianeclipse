package quiz;

public class Quiz05 {

	int max(int[] n) {
		int a = n[0];
		for (int i = 1; i < n.length; i++) {
			if (a < n[i]) {
				a = n[i];
			}
		}
		return a;
	}

	int min(int[] n) {
		int a = n[0];
		for (int i = 1; i < n.length; i++) {
			if (a > n[i]) {
				a = n[i];
			}
		}
		return a;
	}

	public static void main(String[] args) {

		int[] num = { -3829, -219, 0, 43, 3890, 19049 };
		Quiz05 q1 = new Quiz05();
		System.out.println("최대값: " + q1.max(num));
		System.out.println("최소값: " + q1.min(num));

	}

}
