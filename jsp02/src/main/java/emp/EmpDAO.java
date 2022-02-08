package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.DB;

public class EmpDAO {
	public void insert() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			conn.setAutoCommit(false);
			long before = System.currentTimeMillis();
			for (int i = 1; i <= 100000; i++) {
				String sql = "insert into emp2 (empno, ename, deptno) values (?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, i);
				pstmt.setString(2, "kim" + i);
				pstmt.setInt(3, i);
				pstmt.executeUpdate();
				pstmt.close();
			}
			long after = System.currentTimeMillis();
			conn.commit();
			conn.setAutoCommit(true);
			System.out.println("실행시간: " + (after - before));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (conn != null)
					conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void insert_batch() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			conn.setAutoCommit(false);
			String sql = "insert into emp2 (empno, ename, deptno values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			long before = System.currentTimeMillis();
			for (int i = 1000001; i <= 200000; i++) {
				pstmt.setInt(1, i);
				pstmt.setString(2, "kim" + i);
				pstmt.setInt(3, i);
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
			long after = System.currentTimeMillis();
			System.out.println("실행시간: " + (after - before));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
