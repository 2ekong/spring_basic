package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//JpaRepoitory<엔티티명, 엔티티의 @ID필드 타입>
public interface SangpumRepository extends JpaRepository<SangpumDto, Integer>{
	//Repository <- CRUDRepository <- PagingAndSortingRepository <- JpaRepository
	//이제 SangpumRepository는 JpaRepository의 모든 메서드를 사용할 수 있다.
	
	//검색용 추상 메소드
	//쿼리용 메소드 작성 규칙 : findBy 칼람몇, getBy칼람명 , readBy칼람명, ....
	//				      findBy칼람명1AND칼람명2,findBy칼람명1OR칼람명2,
	//					  findBy칼람명1AND칼람명2GreatThan값,findBy칼람명1AND칼람명2GreatThanEqual값,...
	List<SangpumDto> findBySangContaining(String svalue);	//검색어가 포함된 :like '%검색어%'
	//select * from sangdata where sang like '%검색어%'에 의해 검색된 결과가 list collection 담겨 반환됨
	List<SangpumDto> findBySangStartingWith(String svalue);	//검색어가 시작되는 :like '검색어%'
	List<SangpumDto> findBySangEndingWith(String svalue);	//검색어가 끝나는 :like '%검색어'
	
	//JPQL(Java Persistence Query Language)사용 - JPA 지원메소드로 처리할 수 없는 경우 사용하면 효과적
//	JPQL(Java Persistence Query Language)
//	JPA는 SQL을 추상화한 JPQL이라는 객체 지향 쿼리 언어를 제공한다.
//	따라서 테이블을 대상으로 쿼리 하는 것이 아닌 엔티티 객체를 대상으로 쿼리한다.
//	 
//	JPQL은 SQL을 추상화했기 때문에 특정 데이터베이스 SQL에 의존하지 않는 장점이 있다.
//	 
//	JPQL은 SQL과 문법이 유사하며, SELECT, FROM, WHERE, GROUP BY, HAVING, JOIN을 지원한다.
	
	@Query(value = "select s from SangpumDto s where s.sang like %:svalue%")
	List<SangpumDto> searchMyMethod(@Param("svalue")String svalue);	//@Param사용
}

