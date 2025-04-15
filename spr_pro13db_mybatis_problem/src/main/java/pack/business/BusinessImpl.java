package pack.business;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonInter;
import pack.model.SqlMapperInter;
import pack.mybatis.SqlMapConfig;

@Service
public class BusinessImpl implements BusinessInter {

	@Autowired
	private JikwonInter inter;

	@Override
	public void dataPrint() {
		System.out.println("직원 자료");
		List<Map<String, Object>> list = inter.selectList();
		for (Map<String, Object> s : list) {
			System.out.println(s.get("jikwonno") + " " + s.get("jikwonname") + " " + s.get("buser_name") + " "
					+ s.get("ibsayear"));
		}

		SqlSession sqlSession = SqlMapConfig.getSqlSession().openSession();
		SqlMapperInter mapper = sqlSession.getMapper(SqlMapperInter.class);

		System.out.println("부서별 인원수");
		List<Map<String, Object>> countList = mapper.selectBuserCount();
		for (Map<String, Object> c : countList) {
			System.out.println(c.get("buser_name") + " " + c.get("count"));
		}

		System.out.println("부서별 최대 급여자");
		List<Map<String, Object>> topList = mapper.selectMaxPayByBuser();
		for (Map<String, Object> t : topList) {
			System.out.println(t.get("buser_name") + " : " + t.get("jikwonname") + " " + t.get("jikwonpay"));
		}
	}
}
