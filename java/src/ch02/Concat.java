package ch02;

public class Concat {

	public static void main(String[] args) {

		String a = "Hello " + "Java";
		System.out.println(a);

		String b = "Hello " + 100;
		// string과 int라서 오류가 나야 하는데, 이클립스가 자동으로 100을 string으로 바꿔줌
		System.out.println(b);

	}

}
