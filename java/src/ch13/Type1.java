package ch13;

public class Type1 {

	int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static void main(String[] args) {

		Type1 t = new Type1();
		t.setValue(100);
		System.out.println(t.getValue());

	}

}
