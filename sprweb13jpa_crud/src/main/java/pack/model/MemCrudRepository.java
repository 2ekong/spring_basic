package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemCrudRepository extends JpaRepository<Mem, Integer> {
	//레보드 1개 읽기 : JPQL 사용
	@Query(value = "select m from Mem as m where m.num=?1")	//매개변수 사용
	Mem findByNum(String num);
}
