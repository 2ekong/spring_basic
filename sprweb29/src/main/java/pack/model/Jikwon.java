package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;


@Getter
@Entity
@Table(name = "jikwon")
public class Jikwon {
	@Id
	private int jikwonno;
	
	private String jikwonname;
	private String jikwonjik;
	private String jikwongen;
	
	@ManyToOne(targetEntity = Buser.class , fetch = FetchType.EAGER )
	@JoinColumn(name = "busernum")
	private Buser buser;
	
}
