package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.controller.BuserBean;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuserDto {
	//엔티티로부터 필요한 데이터(정보)만 추출하거나 한 후 클라이언트에 전송하는 역할
	private int buserno;
	private String busername;
	private String buserloc;
	private String busertel;
	
	/*
	public static BuserDto fromEntity(Buser entity) {
		BuserDto dto = new BuserDto();
		dto.setBuserno(entity.getBuserno());
		dto.setBusername(entity.getBusername());
		dto.setBuserloc(entity.getBuserloc());
		dto.setBusertel(entity.getBusertel());
		return dto;
	}
	*/
	public static BuserDto fromEntity(Buser entity) {
		return BuserDto.builder()
					.buserno(entity.getBuserno())
					.busername(entity.getBusername())
					.buserloc(entity.getBuserloc())
					.busertel(entity.getBusertel())
					.build();
	}
}
