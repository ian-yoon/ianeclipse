package ch10;

class T {
	private int num = 10;

	public final void print() {
		System.out.println(num);
	}
}

public class FinalMethod extends T {
//	int num = 100;
//	public void print() {
//		System.out.println(num);

	public static void main(String[] args) {
		FinalMethod f = new FinalMethod();
		f.print();

	}

}
