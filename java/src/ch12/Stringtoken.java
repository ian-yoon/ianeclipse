package ch12;

import java.util.StringTokenizer;

public class Stringtoken {

	public static void main(String[] args) {

		String str = "Kim, 20, 180, 65, Seoul, Student";
		String[] items = str.split(", ");
		for (String s : items) {
			System.out.println(s);
		}

		
		StringTokenizer st = new StringTokenizer(str, ", ");
		
		int cnt = st.countTokens();
		System.out.println("Tokens:" + cnt);

		while (st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}

	}

}
