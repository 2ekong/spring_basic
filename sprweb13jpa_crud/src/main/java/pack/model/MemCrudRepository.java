package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemCrudRepository extends JpaRepository<Mem, Integer> {
	//num 자동 증가 처리를 할 경우 Max 집계함수를 사용할수없다. JPQL필요
	//@Query(value = "select m from Mem m where m.num=(select max(m2.num) from Mem m2)")
	//@Query(value = "select max(m.num) from Mem as m")	//JPQL
	//@Query(value = "select max(num) from Mem",nativeQuery = true) //SQL
	//int findByMaxNum();
	
	//레보드 1개 읽기 : JPQL 사용
	@Query(value = "select m from Mem as m where m.num=?1")	//매개변수 사용
	Mem findByNum(String num);
}
