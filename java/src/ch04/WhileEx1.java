package ch04;

public class WhileEx1 {

	public static void main(String[] args) {

		int i = 1;
		while (true) {
			System.out.println(i++);
			// System.out.println(++i); 증가를 먼저 시키고 print를 하라는 뜻이 됨
			if (i > 10)
				break;
		}

		System.out.println("\n");
		
		i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}

	}

}
