package ch02;

import java.util.Scanner;

public class Point {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Name: ");
		String name = sc.next();
		System.out.println("Java: ");
		int java = sc.nextInt();
		System.out.println("DB: ");
		int db = sc.nextInt();
		System.out.println("Math: ");
		int math = sc.nextInt();

		int tot = java + db + math;
		double avg = tot / 3.0;

		System.out.println("Name: " + name);
		System.out.println("Java: " + java);
		System.out.println("DB: " + db);
		System.out.println("Math: " + math);
		System.out.println("Tot: " + tot);
		System.out.println("Avg: " + String.format("%5.1f", avg));

//		if (avg >= 90) {System.out.println("A");
//		} else if (avg >= 80 && avg < 90) {System.out.println("B");
//		} else if (avg >= 70 && avg < 80) {System.out.println("C");
//		} else System.out.println("F");

		sc.close();

	}

}
