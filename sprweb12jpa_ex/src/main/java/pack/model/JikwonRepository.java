package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//JpaRepoitory<엔티티명, 엔티티의 @ID필드 타입>
public interface JikwonRepository extends JpaRepository<JikwonDto, Integer>{

	List<JikwonDto> findByJikContaining(String svalue);
	List<JikwonDto> findByJikStartingWith(String svalue);
	List<JikwonDto> findByJikEndingWith(String svalue);


	
	@Query("select j from JikwonDto j where j.jik is not null and j.jik like %:svalue%")
	List<JikwonDto> searchMyMethod(@Param("svalue") String svalue);	//@Param사용
}

