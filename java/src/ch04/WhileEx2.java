package ch04;

public class WhileEx2 {

	public static void main(String[] args) {
		
		int i = 1;
		int num = 5;
		int sum = 0;
		
		while (i <= num) {
			sum += i;
			i++;
		}

		System.out.println(sum);
		
	}

}
