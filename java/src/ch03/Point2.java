package ch03;

import java.util.Scanner;

public class Point2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("JAVA 점수를 입력하세요: ");
		int java = sc.nextInt();
		System.out.println("DB 점수를 입력하세요: ");
		int db = sc.nextInt();
		System.out.println("Math 점수를 입력하세요: ");
		int math = sc.nextInt();

		int tot = java + db + math;
		double avg = tot / 3.0;

		String grade = "";
		if (avg >= 90 && avg <= 100) {
			grade = "A";
		} else if (avg >= 80 && avg < 90) {
			grade = "B";
		} else if (avg >= 70 && avg < 80) {
			grade = "C";
		} else if (avg >= 60 && avg < 70) {
			grade = "D";
		} else {
			grade = "F";
		}

		System.out.println("JAVA: " + java);
		System.out.println("DB: " + db);
		System.out.println("Math: " + math);
		System.out.println("Total: " + tot);
		System.out.println("Average: " + String.format("%.2f", avg));
		System.out.println("Grade: " + grade);

		sc.close();

	}

}
