package score2;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import sqlmap.MybatisManager;

public class ScoreDAO {
	public List<ScoreDTO> list() {
		SqlSession session = MybatisManager.getInstance().openSession();
		List<ScoreDTO> items = session.selectList("score.list");
		session.close();
		return items;
	}
	public void insert(ScoreDTO dto) {
		SqlSession session = MybatisManager.getInstance().openSession();
		session.insert("score.insert", dto);
		session.commit();
		session.close();
	}
}
