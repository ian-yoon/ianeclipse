package ch01;

public class LongEx {

	public static void main(String[] args) {
		// Ctrl Shift F 코드정렬

		int alpha = 2147483647;
		System.out.println(alpha);
		
		// long은 숫자 뒤에 소문자나 대문자 L 붙여야함
		long beta = 2147483648L;
		System.out.println(beta);

		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.SIZE);

		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.SIZE);
		
		// Integer, Long과 같이 대문자로 시작하는 것은 상수

	}

}
