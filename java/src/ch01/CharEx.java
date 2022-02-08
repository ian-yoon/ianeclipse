package ch01;

public class CharEx {

	public static void main(String[] args) {

		char ch = 'a';
		System.out.println(ch);
		System.out.println((int) ch);
		// (int)는 문자를 자료형으로, 변수 ch의 정수형 코드를 알려주는 것

		for (int i = 0; i <=255; i++) {
			System.out.println(i + "==>" + (char) i);
		}
		
	}

}
