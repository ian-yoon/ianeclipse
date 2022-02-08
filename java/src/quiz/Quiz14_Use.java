package quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Quiz14_Use {
	public static void main(String[] args) {
		
		Quiz14_try[] values= {
				new Quiz14_try("김윤아", 28, 1.54, 54.1),
				new Quiz14_try("박수영", 15, 1.72, 60.0),
				new Quiz14_try("최진희", 32, 1.63, 69.2),
				new Quiz14_try("이도희", 22, 1.57, 48.4),
				new Quiz14_try("정유리", 48, 1.64, 62.1)
			};
		
			Map<String,Object> map=new HashMap<>();
			for(Quiz14_try qt : values) {
				map.put(qt.getName(), qt);
			}
			Scanner sc=new Scanner(System.in);
			System.out.print("회원이름:");
			String str=sc.nextLine();
			Quiz14_try result=(Quiz14_try)map.get(str);
			System.out.println(result);
			
			sc.close();

	}

}
