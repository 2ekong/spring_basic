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
	
	@Autowired
	private DataRepository3 dataRepository3;
	
	public List<GogekDto> gogekList(){
		return dataRepository3.findAll().stream().map(GogekDto :: toDto).collect(Collectors.toList());
	}
	
	public GogekDto findGogek(int gogekno, String gogekname) {
		Gogek gogek = dataRepository3.findByGogeknoAndGogekname(gogekno, gogekname);
		if (gogek == null) return null;
		return GogekDto.toDto(gogek);
	}
	
	public JikwonDto findJikwon(int jikwonno) {
		return JikwonDto.toDto(dataRepository2.findById(jikwonno).orElse(null));
	}
	
	public BuserDto findBuser(int buserno) {
		return BuserDto.toDto(dataRepository.findById(buserno).orElse(null));
	}
}
