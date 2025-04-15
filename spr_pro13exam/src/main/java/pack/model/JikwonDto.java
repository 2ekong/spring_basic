package pack.model;

import java.sql.Date;
import lombok.Data;

@Data
public class JikwonDto {
	private int jikwonno, busernum, jikwonpay;
	private String jikwonname, jikwonjik, jikwongen, jikwonrating;
	private Date jikwonibsail;
	private String busername; // 부서명
}
