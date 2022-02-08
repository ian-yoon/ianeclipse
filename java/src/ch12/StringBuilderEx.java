package ch12;

public class StringBuilderEx {

	public static void main(String[] args) {

		StringBuilder str1 = new StringBuilder();
		str1.append("java");
		System.out.println(str1);
		str1.append(" programming");
		System.out.println(str1);

		String str2 = str1.toString();
		System.out.println(str2);

	}

}
