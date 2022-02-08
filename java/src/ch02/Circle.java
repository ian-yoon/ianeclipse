package ch02;

import java.util.Scanner;

public class Circle {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("반지름 r 값을 입력하세요");
		double r = sc.nextDouble();
		double length = 2 * Math.PI * r;
		double area = Math.PI * r * r;
		System.out.println("R: " + r);
		System.out.println("Circumference: " + String.format("%.2f", length));
		System.out.println("Area: " + String.format("%.2f", area));

		sc.close();
	}

}
