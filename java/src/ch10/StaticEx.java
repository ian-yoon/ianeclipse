package ch10;

public class StaticEx {

	public static void main(String[] args) {

		int a = 40, b = 30, result;
		result = Math.max(a, b);
		System.out.println(result);
		result = Math.min(a, b);
		System.out.println(result);
		System.out.println(Math.sqrt(100));
		double r = 15.4;
		System.out.println("Circumference: " + String.format("%.2f", (2 * Math.PI + r)));
		System.out.println("Area: " + String.format("%.2f", (Math.PI * r * r)));

	}

}
