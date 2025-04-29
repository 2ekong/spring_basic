package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DataRepository3 extends JpaRepository<Gogek, Integer> {

    @Query("select g from Gogek g where g.gogekdamsano = ?1")
    List<Gogek> jikwonDatas(int jikwonno);

    Gogek findByGogeknoAndGogekname(int gogekno, String gogekname);
}
