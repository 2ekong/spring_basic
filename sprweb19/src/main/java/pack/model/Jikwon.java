package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jikwon")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Jikwon {
	@Id
	private int jikwonno;
	
	private String jikwonname;
	private String jikwonjik;
	private int jikwonpay;
	
	//Jikwon엔티티는 Buser엔티티와 다대일 관계
	@ManyToOne
	@JoinColumn(name = "busernum")	//FK 관계설정
	private Buser buser;	// Jikwon에 속한 이 필드는 Buser 엔티티를 참조하기 때문에 Buser 객체에 접근 가능 
	
}
