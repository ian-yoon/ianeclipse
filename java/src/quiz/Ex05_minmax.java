package quiz;

public class Ex05_minmax {
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
		int[] num = { -10, 20, 70, 80, 100 };
		Ex05_minmax m = new Ex05_minmax();
		System.out.println("최대값:" + m.max(num));
		System.out.println("최소값:" + m.min(num));
	}
}
