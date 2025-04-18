package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapperInterface {
	
	@Select("select * from jikwon")
	List<JikwonDto> selectAll();
	
	@Select("select * from jikwon where jikwonjik like concat('%',#{searchValue},'%')")
	List<JikwonDto> selectSearch(String searchValue);
	
	//MariaDB : where sang like concat('%',#{searchValue},'%')
	//Oracle : where sang like '%'||#{searchValue}||'%'	
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
}
