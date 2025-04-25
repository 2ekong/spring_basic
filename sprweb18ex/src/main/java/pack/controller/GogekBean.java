package pack.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.model.Gogek;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GogekBean {
	private int gogekno;
	private String gogekname;
	private String gogektel;
	private String gogekjumin;
	private int gogekdamsano;
	
	public Gogek toEntity() {
		return Gogek.builder()
				.gogekno(this.gogekno)
				.gogekname(this.gogekname)
				.gogektel(this.gogektel)
				.gogekjumin(this.gogekjumin)
				.gogekdamsano(this.gogekdamsano)
				.build();
	}
}
