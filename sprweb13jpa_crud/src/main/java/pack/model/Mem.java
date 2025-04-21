package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	@Column(name="num")
	private int num;
	
	@Column(name = "name", nullable = false)
	private String name;
	private String addr;
}
