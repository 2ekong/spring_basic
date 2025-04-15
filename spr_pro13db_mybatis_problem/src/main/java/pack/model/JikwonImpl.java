package pack.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession(); // singleton

	@Override
	public List<Map<String, Object>> selectList() {
		SqlSession sqlSession = factory.openSession();
		List<Map<String, Object>> list = null;
		SqlMapperInter mapperInter = sqlSession.getMapper(SqlMapperInter.class);

		try {
			list = mapperInter.selectJikwonList();
		} catch (Exception e) {
			System.out.println("selectList err: " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
}
