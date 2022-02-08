package jdbc;

import java.util.Scanner;

public class DeleteMember {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 아이디를 입력하세요.");
		String userid = scan.next();
		int rows = MemberDAO.memberDelete(userid);
		if (rows > 0) {
			System.out.println("삭제되었습니다.");
		scan.close();
		}

	}

}
