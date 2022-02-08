package ch02;

public class Arithmetic {

	public static void main(String[] args) {
		int alpha = 10;
		int beta = 7;
		System.out.println(alpha + beta);
		System.out.println(alpha - beta);
		System.out.println(alpha * beta);
		System.out.println(alpha / beta);
		System.out.println(alpha % beta);

		System.out.println("\n");

		double alpha01 = 10;
		double beta01 = 7;
		System.out.println(alpha01 + beta01);
		System.out.println(alpha01 - beta01);
		System.out.println(alpha01 * beta01);
		System.out.println(alpha01 / beta01);
		System.out.println(alpha01 % beta01);
		System.out.println(String.format("%5.2f", alpha01 / beta01));

	}

}
