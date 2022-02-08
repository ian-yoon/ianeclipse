package memo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DB;
import oracle.jdbc.OracleTypes;

public class MemoDAO {
	public List<MemoDTO> listMemo() {
		List<MemoDTO> items = new ArrayList<>();
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.dbConn();
			String sql = "{call memo_list(?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			rs = (ResultSet) cstmt.getObject(1);
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String writer = rs.getString("writer");
				if (writer.indexOf("<script") != -1 || writer.indexOf("<xmp>") != -1) {
					writer = writer.replace("<", "&lt;");
					writer = writer.replace(">", "&gt;");
				}
				String memo = rs.getString("memo");
				if (memo.indexOf("<script") != -1 || memo.indexOf("<xmp>") != -1) {
					memo = memo.replace("<", "&lt;");
					memo = memo.replace(">", "&gt;");
				}
				Date post_date = rs.getDate("post_date");
				String ip = rs.getString("ip");
				MemoDTO dto = new MemoDTO(idx, writer, memo, post_date, ip);
				items.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (cstmt != null)
					cstmt.close();
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
		return items;
	}

	public void insertMemo(MemoDTO dto) {
		Connection conn = null;
		CallableStatement cstmt = null;
		try {
			conn = DB.dbConn();
			String sql = "{call memo_insert_p(?,?,?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, dto.getWriter());
			cstmt.setString(2, dto.getMemo());
			cstmt.setString(3, dto.getIp());
			cstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
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
