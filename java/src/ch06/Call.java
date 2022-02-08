package ch06;

public class Call {
	static void test1(int b) {
		System.out.println(b);
	}

	static void test2(int[] n) {
		for (int i = 0; i < n.length; i++) {
			System.out.println(n[i] + "\t");
		}
	}

	public static void main(String[] args) {

		System.out.println("start");
		int a = 10;
		test1(a);
		int[] num = { 1, 2, 3, 4, 5 };
		test2(num);
		System.out.println("end");

	}

}
