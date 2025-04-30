package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GogekRepository extends JpaRepository<Gogek, Integer> {

    @Query("SELECT g FROM Gogek g WHERE g.gogekdamsano = :jikwonno AND EXISTS " +
            "(SELECT j FROM Jikwon j WHERE j.jikwonno = :jikwonno AND j.jikwonname = :jikwonname)")
    List<Gogek> findCustomersByJikwon(@Param("jikwonno") int jikwonno, @Param("jikwonname") String jikwonname);

}
