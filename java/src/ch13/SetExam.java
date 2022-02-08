package ch13;

import java.util.HashSet;
import java.util.Set;

public class SetExam {

	public static void main(String[] args) {
		
		Set<String> hs = new HashSet<>();
		hs.add("apple");
		hs.add("peach");
		hs.add("hamster");
		hs.add("grape");
		hs.add("melon");
		hs.add("melon");

		System.out.println(hs);

		for (String str : hs) {
			System.out.println(str);
		}

	}

}
