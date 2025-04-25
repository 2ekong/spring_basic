package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gogek")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gogek {
	@Id
	private int gogekno;
	private String gogekname;
	private String gogektel;
	private String gogekjumin;
	private int gogekdamsano;
	
}
