package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "jikwon")
public class JikwonDto {	
	@Id		
	@Column(name = "jikwonno")	
	private int no;
	@Column(name = "jikwonjik")
	private String jik;
	@Column(name = "jikwonname")
	private String name;
	@Column(name = "jikwongen")
	private String gen;
	@Column(name = "jikwonpay")
	private int pay;
}
