package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "mem")
public class Mem {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)	//자동증가	, DB 컬럼이 반드시 AUTO_INCREMENT (또는 DB에 따라 그에 상응하는 설정) 되어 있어야 정상 동작
	@Column(name="num")
	private int num;
	
	@Column(name = "name", nullable = false)
	private String name;
	private String addr;
}
