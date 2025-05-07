package pack.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {

	@Autowired
	private JikwonRepository jikwonRepository;
	
	@Autowired
	private BuserRepository buserRepository;
	
	//직원 자료 읽기
	public List<Jikwon> jikwonListAll(){
		List<Jikwon> list = jikwonRepository.findAll();
		return list;
	}
	
	public Jikwon jikwonLogin(String jikwonno) {
		//직원 로그인 : JPQL 사용
//		Jikwon jikwon = jikwonRepository.jikwonLogin(jikwonno);
//		return jikwon;
	
		//직원 로그인 : 내장 메소드
		//Optional<Jikwon> jdto = jikwonRepository.findById(Integer.parseInt(jikwonno));
		//jikwon jikwon = jdto.get();
		Jikwon jikwon = jikwonRepository.findById(Integer.parseInt(jikwonno)).get();
		return jikwon;
	}
}
