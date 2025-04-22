package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class DataProcess {

	@Autowired
	private BoardCrudRepository repository;
	
	public List<DataDto> selectAll(){
		return repository.findAll();
	}
	
	public void insert(DataDto dto) {
		repository.save(dto);
	}
	
	
	@Transactional
	public DataDto selectByNum(int num) {
	    repository.increaseReadcnt(num);  // 먼저 증가시키고
	    return repository.findById(num).orElse(null);  // 다시 읽어옴
	}


	
	public void update(DataDto dto) {
		repository.save(dto);
	}
	
	public void delete(int num) {
		repository.deleteById(num);
	}
}
