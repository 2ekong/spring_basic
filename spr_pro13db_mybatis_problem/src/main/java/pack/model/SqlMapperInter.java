package pack.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	@Select("SELECT jikwonno, jikwonname, " +
	        "IFNULL((SELECT busername FROM buser WHERE buserno = j.busernum), '무소속') AS buser_name, " +
	        "YEAR(jikwonibsail) AS ibsayear " +
	        "FROM jikwon j")
	List<Map<String, Object>> selectJikwonList();

	@Select("SELECT IFNULL((SELECT busername FROM buser WHERE buserno = j.busernum), '무소속') AS buser_name, COUNT(*) AS count FROM jikwon j GROUP BY buser_name")
	List<Map<String, Object>> selectBuserCount();

	@Select("SELECT IFNULL((SELECT busername FROM buser WHERE buserno = j.busernum), '무소속') AS buser_name, jikwonname, jikwonpay FROM jikwon j WHERE (busernum, jikwonpay) IN (SELECT busernum, MAX(jikwonpay) FROM jikwon GROUP BY busernum)")
	List<Map<String, Object>> selectMaxPayByBuser();
}
