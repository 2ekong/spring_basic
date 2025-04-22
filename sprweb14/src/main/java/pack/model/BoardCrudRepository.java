package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardCrudRepository extends JpaRepository<DataDto, Integer>{
	// BoardCrudRepository.java
	@Modifying
	@Query("update DataDto d set d.readcnt = d.readcnt + 1 where d.num = :num")
	void increaseReadcnt(@Param("num") int num);

}
