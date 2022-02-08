package ch02;

public class Condition {

	public static void main(String[] args) {

		int num = -5;
		System.out.println(num > 0 ? num : -num);
		// 물음표를 기준으로 좌변이 true면 콜론의 좌변이,
		// 좌변이 false면 콜론의 우변이 출력되는 것

		if (num > 0) {
			System.out.println(num);
		} else {
			System.out.println(-num);
		}

	}

}
