package quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountUse {
	public static void main(String[] args) {
		//객체 배열
		Account[] values= {
			new Account("국민은행","111-1111-111-11","김철수",1000000),
			new Account("하나은행","222-1111-111-11","김민호",2000000),
			new Account("우리은행","333-1111-111-11","송민수",3000000),
			new Account("농협은행","444-1111-111-11","박성민",4000000),
			new Account("수협은행","555-1111-111-11","장성훈",5000000)
		};
		
		Map<String,Object> map=new HashMap<>();
		for(Account acc : values) {
			map.put(acc.getNum(), acc);
		}
		
		Scanner sc=new Scanner(System.in);
		System.out.print("계좌번호:");
		String str=sc.nextLine();
		Account result=(Account)map.get(str);
		System.out.println(result);
		
		sc.close();
	}
}
