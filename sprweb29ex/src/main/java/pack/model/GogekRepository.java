package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GogekRepository extends JpaRepository<Gogek, Integer>{
	 @Query("select g from Gogek as g where g.gogekno = :gogekno and g.gogekname = :gogekname")
	    Gogek findByGogeknoAndGogekname(@Param("gogekno") int gogekno, @Param("gogekname") String gogekname);
}
                   