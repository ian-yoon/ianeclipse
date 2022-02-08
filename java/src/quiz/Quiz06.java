package quiz;

import java.util.Scanner;

public class Quiz06 {

	static double getDistance(int x1, int y1, int x2, int y2) {
		double d;
		int xd, yd;
		yd = (int) Math.pow((y2 - y1), 2); // 세로변 길이의 제곱
		xd = (int) Math.pow((x2 - x1), 2); // 가로변 길이의 제곱
		d = Math.sqrt(yd + xd); // 루트(가로변 길이의 제곱 더하기 세로변 길이의 제곱)
		return d;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("x1, x2, y1, y2의 값을 차례대로 입력하세요.");
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y1 = sc.nextInt();
		int y2 = sc.nextInt();

		System.out.println(String.format(String.format("%.2f", getDistance(x1, x2, y1, y2))));

		sc.close();
	}

}
