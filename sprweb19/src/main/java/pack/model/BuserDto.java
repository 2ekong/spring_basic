package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuserDto {
	private int buserno;
	private String busername;
	private String buserloc;
	private String busertel;
	
	//Dto -> Entity
	/*
	public Buser toEntity() {
		Buser buser = new Buser();
		buser.setBuserno(this.buserno);
		buser.setBusername(this.busername);
		buser.setBuserloc(this.buserloc);
		buser.setBusertel(this.busertel);
		return buser;
	}
	*/
	
	public Buser toEntity() {
		return Buser.builder()
				.buserno(this.buserno)
				.busername(this.busername)
				.buserloc(this.buserloc)
				.busertel(this.busertel)
				.build();
	}
	
	//Entity -> Dto
	/*
	public static BuserDto fromEntity(Buser buser) {
		BuserDto dto = new BuserDto();
		dto.setBuserno(buser.getBuserno());
		dto.setBusername(buser.getBusername());
		dto.setBuserloc(buser.getBuserloc());
		dto.setBusertel(buser.getBusertel());
		return dto;
	}
	*/
	
	public static BuserDto fromEntity(Buser buser) {
		return BuserDto.builder()
				.buserno(buser.getBuserno())
				.busername(buser.getBusername())
				.buserloc(buser.getBuserloc())
				.busertel(buser.getBusertel())
				.build();
	}
	
}
