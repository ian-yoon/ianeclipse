package ch12;

import java.math.BigDecimal;

public class DoubleEx {

	public static void main(String[] args) {

		Double num1 = 11.5;
		double num2 = 3.5;
		double num3 = num1 / num2;
		System.out.println(num3);
		System.out.println(String.format("%.2f", num3));

		String str = "11.5";
		System.out.println(str + 200);
		System.out.println(Double.parseDouble(str) + 200);

		// double 형의 오차와 극복 방법

		double a = 1.6;
		double b = 0.1;
		System.out.println(a + b);
		System.out.println(a * b);

		BigDecimal c = new BigDecimal("1.6");
		BigDecimal d = new BigDecimal("0.1");
		System.out.println(c.add(d));
		System.out.println(c.multiply(d));

	}

}
