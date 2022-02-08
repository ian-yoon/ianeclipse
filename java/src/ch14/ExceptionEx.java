package ch14;

public class ExceptionEx {

	public static void main(String[] args) {
		
		int a = 10, b = 0, c;
		try {
			c = a / b;
			System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");

	}

}
