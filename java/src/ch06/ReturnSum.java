package ch06;

public class ReturnSum {
	static int sum(int a) {
		int result = 0;
		for (int i=1; i<=a; i++) {
			result += i;
		}
		return result;
	}

	public static void main(String[] args) {
		
		int n = sum(50);
		System.out.println(n);
		n = sum(100);
		System.out.println(n);
		
		System.out.println(sum(100)); // 변수 정하지 않고 그냥 바로 이렇게 출력해도 됨

	}

}
