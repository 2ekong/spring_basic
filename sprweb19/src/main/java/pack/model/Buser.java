package pack.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "buser")
@Getter
@Setter
@Builder
public class Buser {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int buserno;
	
	private String busername;
	private String buserloc;
	private String busertel;
	
	@OneToMany(mappedBy = "buser", fetch = FetchType.LAZY)		//Jikwon 엔티티의 buser 필드를 기준으로 매핑관계가 됨을 나타냄
	//mappedBy = "buser"는 주인이 아님을 나타냄 즉 연관 관계 주인은 jikwon엔티티가 된다
	private List<Jikwon> jikwonList;	//Jikwon엔티티들에 리스트
	
}
