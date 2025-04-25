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
public class GogekDto {
	private int gogekno;
	private String gogekname;
	private String gogektel;
	private String gogekjumin;
	private int gogekdamsano;
	
	public static GogekDto fromEntity(Gogek entity) {
		return GogekDto.builder()
				.gogekno(entity.getGogekno())
				.gogekname(entity.getGogekname())
				.gogektel(entity.getGogektel())
				.gogekjumin(entity.getGogekjumin())
				.gogekdamsano(entity.getGogekdamsano())
				.build();
	}
	
	public String getGender() {
	    String jumin = getCleanJumin();
	    if (jumin.length() >= 7) {
	        char genderCode = jumin.charAt(6);
	        return switch (genderCode) {
	            case '1', '3' -> "남성";
	            case '2', '4' -> "여성";
	            default -> "알 수 없음";
	        };
	    }
	    return "정보 없음";
	}

	public int getAge() {
	    String jumin = getCleanJumin();
	    if (jumin.length() >= 7) {
	        int birthYear = Integer.parseInt(jumin.substring(0, 2));
	        char genderCode = jumin.charAt(6);

	        birthYear += (genderCode == '1' || genderCode == '2') ? 1900 :
	                     (genderCode == '3' || genderCode == '4') ? 2000 : 0;

	        if (birthYear == 0) return 0; 

	        int currentYear = java.time.Year.now().getValue();
	        return currentYear - birthYear + 1;  
	    }
	    return 0;
	}

	private String getCleanJumin() {
	    return gogekjumin != null ? gogekjumin.trim().replace("-", "") : "";
	}


}
