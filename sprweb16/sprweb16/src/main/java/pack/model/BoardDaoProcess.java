package pack.model;

import pack.controller.BoardBean;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoardDaoProcess {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BoardRepository repository;

    // 전체 자료 읽기
    public Page<Board> listAll(int page) {
        // 둘 다 내림차순
//        List<Board> list = repository.findAll(Sort.by(Sort.Order.desc("gnum"), Sort.Order.desc("onum")));
//        List<Board> list = repository.findAll(Sort.by(Sort.Direction.DESC, "gnum", "onum"));
//        List<Board> list = repository.findAll(Sort.by(Sort.Order.desc("gnum"), Sort.Order.asc("onum")));
        Sort sort = Sort.by(Sort.Order.desc("gnum"), Sort.Order.asc("onum"));
        Pageable paging = PageRequest.of(page, 10, sort);
        Page<Board> list = repository.findAll(paging);

        // JPA는 0-based index를 반환하므로 +1을 줌
        System.out.println("page number: " + list.getPageable().getPageNumber() + 1);
        System.out.println("page size: " + list.getSize());
        System.out.println("total page: " + list.getTotalPages());
        System.out.println("total count: " + list.getTotalElements());
        System.out.println("next: " + list.nextPageable()); // 다음 페이지 유무

        logger.info("반환된 레코드 수: {}", list.getContent().size());
        return list;
    }

    // 검색용
    public Page<Board> search(BoardBean bean) {
        Sort sort = Sort.by(Sort.Order.desc("gnum"), Sort.Order.asc("onum"));
        Pageable paging = PageRequest.of(0, 10, sort);
        Page<Board> slist = null;

        if (bean.getSearchName().equals("name")) {
            slist = repository.searchLike1(paging, bean.getSearchValue());
        } else {
            slist = repository.searchLike2(paging, bean.getSearchValue());
        }

        return slist;
    }

    public int currentMaxNum() { // 새 글 추가 시 num 구하기
        return repository.maxNum();
    }

    // @Transactional // 성공하면 commit 실패하면 rollback 해준다.
    public void insert(BoardBean bean) {
            Board board = new Board();
            board.setNum(bean.getNum());
            board.setName(bean.getName());
            board.setPass(bean.getPass());
            board.setMail(bean.getMail());
            board.setTitle(bean.getTitle());
            board.setCont(bean.getCont());
            board.setBip(bean.getBip());
            board.setBdate(bean.getBdate());
            board.setReadcnt(bean.getReadcnt());
            board.setGnum(bean.getGnum());
            board.setOnum(bean.getOnum());
            board.setNested(bean.getNested());
            repository.save(board); //Dto 저장(DB에 저장), insert into ...
        
    }
    
    //상세보기용 조회수 증가
    @Transactional
    public void updateReadCnt(int num) {
    	repository.updateReadCnt(num);	
    }
    
    public Board detail(int num) {	//상세보기, 글수정, 댓글 등에서 사용
    	Optional<Board> board =  repository.findById(num);	
    	logger.info("board : {}", board.get());	//Optional => Board type 으로 변환
    	
    	if(board.isPresent()) {
    		return board.get();
    	}else {
    		return new Board();
    	}
    	
    }
    
    //수정 시 비밀번호 비교용
    public String selectPass(int num) {
    	return repository.selectPass(num);
    }
    
    //수정작업
//    @Transactional
//    public String update(BoardBean bean) {
//    	try {
//    		Optional<Board> board = repository.findById(bean.getNum());
//    		Board dto  = board.get();
//    		dto.setName(bean.getName());
//    		dto.setMail(bean.getMail());
//    		dto.setTitle(bean.getTitle());
//    		dto.setCont(bean.getCont());
//    		//repository.save(dto);-
//    		//save()를 사용하지 않아도 수정이 됨
//			return "success";
//		} catch (Exception e) {
//			return "수정자료 오류 : " + e;
//		}
//    	
//    }
    
    @Transactional
    public void update(BoardBean bean) {
    	Optional<Board> board = repository.findById(bean.getNum());
		Board dto  = board.get();
		dto.setName(bean.getName());
		dto.setMail(bean.getMail());
		dto.setTitle(bean.getTitle());
		dto.setCont(bean.getCont());
		//repository.save(dto);
    }
    
    @Transactional
    public void delete(int num) {
    	repository.deleteById(num);
    }
    
    //댓글 처리
    @Transactional
    public void updateOnum(BoardBean bean) {
    	repository.updataOnum(bean.getGnum(), bean.getOnum());
    }
    
    @Transactional
    public void insertReply(BoardBean bean) {
    	Board board = new Board();
    	board.setNum(bean.getNum());
        board.setName(bean.getName());
        board.setPass(bean.getPass());
        board.setMail(bean.getMail());
        board.setTitle(bean.getTitle());
        board.setCont(bean.getCont());
        board.setBip(bean.getBip());
        board.setBdate(bean.getBdate());
        board.setReadcnt(0);
        board.setGnum(bean.getGnum());
        board.setOnum(bean.getOnum());
        board.setNested(bean.getNested());
        repository.save(board);
    }
    
}
