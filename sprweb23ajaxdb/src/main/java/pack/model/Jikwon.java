package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Jikwon {
	@Id
	private int Jikwonno;
	private String Jikwonname;
	private String Jikwonjik;
	
	@Column(name = "busernum")
	private String buser;
	
	
}
