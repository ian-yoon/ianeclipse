package quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemberUse {
	public static void main(String[] args) {
		Member[] members={
			new Member("kim",20,180,65),
			new Member("park",21,185,70),
			new Member("hong",22,190,85),
			new Member("choi",23,160,50),
			new Member("lee",24,165,55)
		};
		Map<String,Member> map=new HashMap<>();
		// map.put(key,value)
		for(Member m : members){
			map.put(m.getName(), m);
		}
		//System.out.println(map);
		Scanner scan=new Scanner(System.in);
		System.out.println("이름을 입력하세요:");
		String name=scan.nextLine();
		//map.get(key)
		Member result= map.get(name);
		System.out.println(result);
	}
}











