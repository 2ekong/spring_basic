package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {	//클라이언트 <-> DB: 처리용 클래스 <-> JPA <-> JDBC <-> RDBMS
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JikwonRepository repository;
	
	//전체 자료 읽기
	public List<JikwonDto> getDataAll(){
		List<JikwonDto> list = repository.findAll();	//내장된 기본 메소드
		logger.info("행의 갯수 : " + list.size() + "개");
		return list;
	}
	
	//검색 처리
	public List<JikwonDto> getDataSearch(String svalue){
		List<JikwonDto> list = repository.searchMyMethod(svalue);
		
		logger.info("검색 결과 행의 갯수 : " + list.size() + "개");
		list.forEach(JikwonDto -> System.out.println(JikwonDto.getNo() + " " + JikwonDto.getName() + " " + JikwonDto.getGen() + " " + JikwonDto.getPay()));
		
		return list;
	}
	
}
