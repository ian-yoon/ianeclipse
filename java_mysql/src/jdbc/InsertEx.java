package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class InsertEx {

	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("c:/work/db.prop");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String id = prop.getProperty("id");
		String password = prop.getProperty("password");
		Connection conn = null;
		PreparedStatement stmt = null;

		conn = DriverManager.getConnection(url, id, password);
		Scanner sc = new Scanner(System.in);
		System.out.println("제목을 입력하세요.");
		String title = sc.next();
		System.out.println("저자를 입력하세요.");
		String author = sc.next();
		System.out.println("발행년도를 입력하세요.");
		String year = sc.next();
		System.out.println("가격을 입력하세요.");
		int price = sc.nextInt();
//		String title = "Python";
//		String author = "hong";
//		String year = "2021";
//		int price = 40000;
		String sql = "insert into books (title, author, year, price) values (?, ?, ?, ?)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, title);
		stmt.setString(2, author);
		stmt.setString(3, year);
		stmt.setInt(4, price);
		stmt.executeUpdate();
		System.out.println("추가되었습니다.");

		if (stmt != null)
			conn.close();

		sc.close();

	}

}
