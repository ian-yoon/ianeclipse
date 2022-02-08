package ch13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapExam {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("apple", "사과");
		System.out.println(map.get("apple"));
		map.put("grape", "포도");
		map.put("pear", "배");
		System.out.println(map);

		String input = "grape";
		System.out.println(input + " ==> " + map.get(input));

		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.print("key=" + key);
			System.out.println(", value=" + map.get(key));
		}

	}

}
