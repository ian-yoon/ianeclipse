package ch06;

public class Params {
	static int plus(int a, int b) {
		return a + b;
	}

	static int minus(int a, int b) {
		return a - b;
	}

	static int multi(int a, int b) {
		return a * b;
	}

	static int divide(int a, int b) {
		return a / b;
	}

	public static void main(String[] args) {
		
		System.out.println(plus(10, 20));
		System.out.println(minus(100, 50));
		System.out.println(multi(10, 5));
		System.out.println(divide(10,5));

	}

}
