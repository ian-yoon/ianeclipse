package ch12;

public class StringEx {

	public static void main(String[] args) {

		String str = "Hello Java";
		System.out.println(str);

		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());

		System.out.println(str); // String은 final이기 때문에 처음의 값 Hello Java가 그대로 나옴

		str = str.toLowerCase();
		System.out.println(str);

		str = "";
		System.out.println(str);
		str = null;
		System.out.println(str);

		char ch = '\0';
		System.out.println(ch + ", code: " + (int) ch);
		ch = ' ';
		System.out.println(ch + ", code: " + (int) ch);
	}

}
