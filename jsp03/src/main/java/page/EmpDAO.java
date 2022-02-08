package page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import sqlmap.MybatisManager;

public class EmpDAO {
	public List<EmpDTO> list(int start, int end) {
		List<EmpDTO> items = null;
		SqlSession session = MybatisManager.getInstance().openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		items = session.selectList("emp.list", map);
		return items;
	}

	public int count() {
		int count = 0;
		SqlSession session = null;
		try {
			session = MybatisManager.getInstance().openSession();
			count = session.selectOne("emp.count");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return count;
	}

}
