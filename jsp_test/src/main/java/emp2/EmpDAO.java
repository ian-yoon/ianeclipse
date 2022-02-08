package emp2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sqlmap.MybatisManager;

public class EmpDAO {
	public List<EmpDTO> list() {
		SqlSession session = MybatisManager.getInstance().openSession();
		List<EmpDTO> items = session.selectList("emp.list"); // xml에 네임스페이스 emp, 아이디 list인 태그 만들 것
		session.close();
		return items;
	}
	public void insert(EmpDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.insert("emp.insert", dto);
		session.commit();
		session.close();
	}

}
