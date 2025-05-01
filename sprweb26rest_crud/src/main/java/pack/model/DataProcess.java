package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pack.controller.MemBean;

@Repository
public class DataProcess {
	@Autowired
	private MemCrudRepository repository;
	
	//전체 자료 반환
	public List<Mem> getDataAll(){
		List<Mem> list = repository.findAll();
		return list;
	}
	
	//수정, 삭제를 위한 레코드 읽기
	public Mem getData(String num) {
		Mem mem = repository.findByNum(num);
		return mem;
	}
	
	//추가
	@Transactional
	public String insert(MemBean bean) {
		//int max = repository.findByMaxNum();	//번호 자동 증가시
		/*
		//입력한 번호 확인
		try {
			Mem mem = repository.findById(bean.getNum()).get();
			return "이미 등록된 번호 입니다.";
		} catch (Exception e) {
			//등록 가능한 번호 
			try {
				Mem mem = new Mem(bean.getNum(), bean.getName(), bean.getAddr());
				repository.save(mem);
				return "success";
			} catch (Exception e2) {
				return "입력 자료 오류 입니다." + e2.getMessage();
			}
		}
		*/
		if(repository.findById(bean.getNum()).isPresent()) {
			return "이미 등록된 번호 입니다.";	
		}
		try {
			Mem mem = new Mem(bean.getNum(), bean.getName(), bean.getAddr());
			repository.save(mem);	//insert
			return "success";
		} catch (Exception e) {
			throw new RuntimeException("error" + e.getMessage());	//Spring이 자동으로 rollback함
			
		}
	}
	
	//수정
	@Transactional
	public void update(MemBean bean) {
		try {
			Mem mem = new Mem(bean.getNum(), bean.getName(), bean.getAddr());
			repository.save(mem);	//update
		} catch (Exception e) {
			throw new RuntimeException("error" + e.getMessage());	//Spring이 자동으로 rollback함
			
		}
	}
	
	//삭제
	@Transactional
	public void delete(int num) {
		try {
			repository.deleteById(num);
		} catch (Exception e) {
			throw new RuntimeException("error" + e.getMessage());	//Spring이 자동으로 rollback함
		}
	}
	
}
