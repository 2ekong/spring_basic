package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity	//원본 테이블과 mapping
@Table(name = "mem")	//실제 테이블명
public class MemDto {
	@Id
	@Column(name="num")
	private int num;
	
	@Column(name = "name", nullable = true)
	private String name;
	
	//@Column(name = "addr", nullable = true)
	private String addr;
	
	
}
