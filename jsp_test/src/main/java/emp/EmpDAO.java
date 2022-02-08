package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DB;

public class EmpDAO {

	public List<EmpDTO> list() {
		List<EmpDTO> items = new ArrayList<>();
		Connection conn = null; // db 접속
		PreparedStatement pstmt = null; // sql 실행
		ResultSet rs = null; // 레코드셋 탐색하는 cursor 역할
		try {
			conn = DB.dbConn(); // DB.dbConn() 통해서 oraDB 접속
			String sql = "select * from emp_copy";
			pstmt = conn.prepareStatement(sql); // sql 실행 객체를 생성
			rs = pstmt.executeQuery(); // sql 실행하고 결과셋의 시작 번지 값을 rs에 전달
			while (rs.next()) { // 시작 번지 값부터 rs가 레코드를 하나씩 읽음
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setSal(rs.getInt("sal"));
				items.add(dto); // ArrayList items에 dto의 값들을 추가합니다
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items; // 마지막에 ArrayList 출력
	}

	public void insert(EmpDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.dbConn();
			String sql = "insert into emp_copy (empno, ename, sal) values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getEmpno());
			pstmt.setString(2, dto.getEname());
			pstmt.setInt(3, dto.getSal());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
