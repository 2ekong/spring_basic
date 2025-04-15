package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EtcMapper {

	@Select("select j.jikwonno, j.jikwonname, b.busername, j.jikwonibsail from jikwon j left join buser b on j.busernum = b.buserno")
	List<JikwonDto> selectAllList();

	@Select("SELECT IFNULL(b.busername, '무소속') AS busername, COUNT(*) AS count FROM jikwon j LEFT JOIN buser b ON j.busernum = b.buserno GROUP BY b.busername")
	List<DeptCountDto> getDeptCount();

	@Select("SELECT IFNULL(b.busername, '무소속') AS busername, j.jikwonname, j.jikwonpay FROM jikwon j LEFT JOIN buser b ON j.busernum = b.buserno WHERE (j.busernum, jikwonpay) IN (SELECT j2.busernum, MAX(j2.jikwonpay) FROM jikwon j2 GROUP BY j2.busernum)")
	List<DeptMaxPayDto> getDeptMaxPay();
}
