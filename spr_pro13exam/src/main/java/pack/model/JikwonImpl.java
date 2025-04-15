package pack.model;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	@Override
	public List<JikwonDto> selectAllList() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		try {
			list = sqlSession.selectList("dev.selectDataAll");
		} catch (Exception e) {
			System.out.println("selectAllList err: " + e);
		} finally {
			sqlSession.close();
		}
		return list;
	}
}
