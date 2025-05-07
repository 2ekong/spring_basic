package pack.model;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {

    @Autowired
    private JikwonRepository jikwonRepository;
    
    @Autowired
    private BuserRepository buserRepository;
    
    @Autowired
    private GogekRepository gogekRepository;
    
    // 고객 로그인 (고객 번호와 이름으로 인증)
    public Gogek gogekLogin(int gogekno, String gogekname) {
        return gogekRepository.findByGogeknoAndGogekname(gogekno, gogekname);
    }

    // 담당 직원 목록 가져오기
    public List<Jikwon> findJikwonByGogekno(int gogekno) {
        Gogek gogek = gogekRepository.findById(gogekno).orElse(null);
        if (gogek != null && gogek.getJikwon() != null) {
            return Collections.singletonList(gogek.getJikwon());
        }
        return Collections.emptyList();
    }
}
