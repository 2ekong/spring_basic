package pack.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JikwonDto {
	private int Jikwonno;
	private String Jikwonname;
	private String Jikwonjik;
	private String buser;
	
	public static JikwonDto toDto(Jikwon jikwon) {
		return JikwonDto.builder()
				.Jikwonno(jikwon.getJikwonno())
				.Jikwonname(jikwon.getJikwonname())
				.Jikwonjik(jikwon.getJikwonjik())
				.buser(jikwon.getBuser())
				.build();
	}
}
