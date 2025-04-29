package pack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class DataDao {
	@Autowired
	private DataRepository dataRepository;
	
	@Autowired
	private DataRepository2 dataRepository2;
	
	//부서 자료 읽기
	public List<BuserDto> buserList(){
		List<BuserDto> blist = dataRepository.findAll().stream().map(BuserDto :: toDto).collect(Collectors.toList());
		return blist;
	}
	//직원 자료 읽기
	public List<JikwonDto> jikwonList(int buserno){
		/*
		List<JikwonDto> jlist = new ArrayList<JikwonDto>();
		
		//방법 1 : 향상된 for
		for(Jikwon jikwon : dataRepository2.buserDatas(buserno)) {
			jlist.add(JikwonDto.toDto(jikwon));
		}
		*/
		//방법 2 : Lambda 사용 ::
		List<JikwonDto> jlist = dataRepository2.buserDatas(buserno).stream().map(JikwonDto :: toDto).collect(Collectors.toList());
		return jlist;
	}
}
