package ch13;

// 이게 일반화 방법

public class Type3<T> {
	T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public static void main(String[] args) {

		Type3<String> t = new Type3<String>();
		t.setT("100");
		System.out.println(t.getT());
		Type3<Integer> t2 = new Type3<Integer>();
		t2.setT(10);
		System.out.println(t2.getT());
	}

}
